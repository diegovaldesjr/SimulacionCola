/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.Simulacion.Cero;
import Modelo.Cliente;
import Modelo.Probabilidad;
import Modelo.Servidor;
import Modelo.Tiempo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Diego Valdes
 */
public class Estacion extends javax.swing.JPanel {

    public static DefaultTableModel ModelCliente;
    public static DefaultTableModel ModelEvento;
    public static DefaultTableModel ModelResultados;
    
    private ArrayList<Servidor> Servidores;
    private ArrayList<Cliente> Cola;
    
    private int AT;
    private int menorDT;
    
    private final int MinServer = 1;
    private int MaxServer;
    private int NumeroEstacion;
    
    private Simulacion s;
    
    Cliente entrante;
    Cliente nuevo;
    
    //Clientes que hay actualmente en la estacion
    private int nClientes;
    
    private int nClientesCola;
    private int nClientesServidos;
    private int nClientesNoEspera;
    
    private int nEvento;
    
    private int ultimoTM;
    private int tiempoAdicional;
    private float tiempoPromedioAdicional;
    
    private ArrayList<Tiempo> tiemposEntreSalidas;
    
    private float W;
    private float Wq;
    private float tiempoPromedioHaceCola;
    private float L;
    private float Lq;
    
    
    /**
     * Creates new form Estacion
     */
    public Estacion(Simulacion s, int NumeroEstacion, ArrayList<Tiempo> tiemposEntreSalidas) {
        initComponents();
        
        this.s = s;
        
        //Cola de la estacion
        Cola = new ArrayList<Cliente>();
        
        int MaxServer = 0;   
        while(MaxServer <= Cero){
            MaxServer = Integer.parseInt(JOptionPane.showInputDialog("Por Favor, ingrese la cantidad de servidores para la estacion "+NumeroEstacion));
            System.out.println("Servidores "+MaxServer);
        }
        this.MaxServer = MaxServer;
        
        //Servidores de la estacion
        Servidores = new ArrayList<Servidor>();
        
        for (int i = 0; i < MaxServer; i++) {
            Servidores.add(new Servidor());
        }
        
        //Numero de estacion
        this.NumeroEstacion = NumeroEstacion;

        nEvento = 0;
        
        nClientesCola = 0;
        nClientesServidos = 0;
        nClientesNoEspera = 0;
        
        this.tiemposEntreSalidas = tiemposEntreSalidas;
        
        tiempoAdicional = 0;
     
        W = 0;
        Wq = 0;
        L = 0;
        Lq = 0;
        tiempoPromedioHaceCola = 0;
        
        initTablaEventos();
        initTablaClientes();
        initTablaResultados();
        initEstacion();
        
    }
    
    /*****************************************************************************************************************************/
    
    public void initTablaEventos(){
        //Modelo para mostrar los eventos
        ModelEvento = new DefaultTableModel();
        ModelEvento.addColumn("# Evento");
        ModelEvento.addColumn("Tipo de evento");
        ModelEvento.addColumn("# Cliente");
        ModelEvento.addColumn("TMd");
        ModelEvento.addColumn("TMm");
        ModelEvento.addColumn("SS");
        ModelEvento.addColumn("WL");
        ModelEvento.addColumn("AT");
        ModelEvento.addColumn("DT");
        this.tablaEvento.setModel(ModelEvento);
    }
    public void initTablaClientes(){
        //Modelo para mostrar los clientes
        ModelCliente = new DefaultTableModel();
        ModelCliente.addColumn("Cliente");
        ModelCliente.addColumn("Entrada");
        ModelCliente.addColumn("Salida");
        this.tablaCliente.setModel(ModelCliente);
    }
    public void initTablaResultados(){
        //Modelo para la tabla de resultados
        ModelResultados = new DefaultTableModel();
        ModelResultados.addColumn("Descripcion");
        ModelResultados.addColumn("Resultado");
        this.tablaResultados.setModel(ModelResultados);
    }
    
    public void initEstacion(){
        AT = 0;
        menorDT = Simulacion.Infinito;
        
        for(Servidor servidor: Servidores){
            servidor.setDT(Simulacion.Infinito);
        }
        
        this.ultimoTM = 0;
        
        for(Servidor servidor: Servidores){
            servidor.setCliente(null);
        }
        
        Cola.clear();
        
        nClientes = 0;
   
        if(NumeroEstacion == 1)
            entrante = new Cliente(Cero, s.GetTiempoEntreSalidas(tiemposEntreSalidas));
        else
            entrante = null;
        
        nuevo = null;
    }
    
    /*****************************************************************************************************************************/
    
    //Retorna 1 si todos los servidores estan vacios
    //Retorna 0 si algun servidor llega a estar ocupado
    public boolean ServidoresVacios(){
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                return false;
            }
        }
        return true;
    }
    
    public void simulacionCola(){
        //Solo se generan cliente para entrar en la primera estacion
        menorDT = Simulacion.Infinito;
        
        for(Servidor servidor: Servidores){
            if(menorDT > servidor.getDT())
                menorDT = servidor.getDT();
        }
        
        if(AT < menorDT && NumeroEstacion == 1 && s.getTMm() < s.getMaxTMm() && s.verificarCapacidad()){
            //Actualiza TM
            s.setTMm(AT);

            Insertar(entrante, false);
            
        }else if(nClientes != Cero && !ServidoresVacios()){
            //Actualizo TM
            s.setTMm(menorDT);

            //Llamo funcion que saca a cliente del servidor que dejara de ser atendido
            VaciarServidor();
        }
        ultimoTM = s.getTMm();
        
        System.out.println("AT "+AT);
        System.out.println("DT "+menorDT);
        System.out.println("TM "+s.getTMm());
    }
    
    //Retorna 1 si alguno de los servidores esta vacios
    //Retorna 0 si todos servidores llegan a estar ocupado
    public boolean ServidorDisponible(){
        int estado = 0;
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                estado++;
            }
        }
        
        if(estado == MaxServer)
            return false;
        else
            return true;
    }
    
    //Inserta un en la estacion, verificar si puede ser atendido o si tendra que
    //Esperar en cola
    public void Insertar(Cliente cliente, boolean clienteEnCola){
        //Registrar que cuenta de clientes que han pasado por el servidor
        if(!clienteEnCola){
            //Anuncia al cliente a entrar en el sistema
            AnunciarCliente(cliente);
            nClientes++;
            
            cliente.setEntrada(s.getTMm());
        }
        
        //Si algun servidor esta desocupado en la primera estacion
        if(ServidorDisponible()){
            //Insertar nuevo cliente en algun servidor desocupado
            nClientesServidos++;
            
            if(!clienteEnCola)
                nClientesNoEspera++;
            
            atenderCliente(cliente);
        }else{
            //Añadir al cliente en la cola
            System.out.println("Añadir cliente a Cola");
            Cola.add(cliente);
            nClientesCola++;
        }
        
        if(!clienteEnCola){
           if(NumeroEstacion == 1){
                //Se genera el proximo cliente a llegar en la siguiente iteracion
                nuevo = s.pedirCliente(tiemposEntreSalidas);
            }else{
                //Pedir proximo a salir de la estacion anterior
                nuevo = s.proximoEnSalir(NumeroEstacion);
                System.out.println("Otra estacion");
            }

            //Actualizo AT
            AT = s.getTMm() + nuevo.getIT();
            //Anuncio evento de entrada
            AnunciarEvento("Entrada",cliente);
            
            entrante = nuevo;
        }
    }
    
    //Inserta un cliente en un servidor desocupado en una estacion dada
    private void atenderCliente(Cliente cliente){
        ArrayList<Servidor> opciones = new ArrayList<>();
        
        //Busca servidores disponibles
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() == null){
                opciones.add(servidor);
            }
        }
        
        //Genera un numero random que sera el indice correspondiente a una estacion desocupada
        int rand = s.GetInterval(Cero, opciones.size()-1);
        System.out.println("Entra a estacion "+ NumeroEstacion+ " el cliente " + cliente.getNumeroCliente());
        
        //El cliente pasa a ser atendido
        opciones.get(rand).setCliente(cliente);
        
        //Actualizo DT
        opciones.get(rand).setDT(s.getTMm() + cliente.getST());
        menorDT = s.getTMm() + cliente.getST();
    }
    
    //Ejecuta una salida de un cliente de la estacion y si hay una siguiente
    //Lo inserta en ella
    private void VaciarServidor(){
        Servidor servidorAVaciar = null;
        Cliente cliente;
        
        //Se busca por las estaciones el servidor cuyo cliente tenga su tiempo de salida
        //Igual al tiempo actual
        for(Servidor servidor: Servidores){
            if(servidor.getDT() == menorDT){
                servidorAVaciar = servidor;
                System.out.println("Encontro servidor a vaciar");
            }
        }
        
        
        //Si encontro el servidor a desocupar
        if(servidorAVaciar != null){
            //Se saca al cliente del servidor
            cliente = servidorAVaciar.getCliente();
            servidorAVaciar.setCliente(null);
            
            //Aqui faltan registrar datos para las estadisticas
            
            //Se verfica si la cola tiene personas
            if(Cola.size() > 0){
                //Sacar el primero en la cola y colocarlo en servidor
                Cliente primeroEnCola = Cola.get(0);
                Cola.remove(0);
                servidorAVaciar.setDT(s.getTMm() + cliente.getST());
                menorDT = s.getTMm() + cliente.getST();
                
                Wq += (float) (s.getTMm()-cliente.getEntrada());
                
                Insertar(primeroEnCola, true);
            }else{
                //Actualizar DT a infito para que llegue otro cliente en la siguiente iteracion
                servidorAVaciar.setDT(Simulacion.Infinito);
                menorDT = Simulacion.Infinito;
            }
            AnunciarEvento("Salida", cliente);
            
            nClientes--;
            W += (float) (s.getTMm()-cliente.getEntrada());
            s.avanzarCliente(cliente, NumeroEstacion);
            
            
            System.out.println("Sale de la estacion "+ NumeroEstacion + " el cliente" + cliente.getNumeroCliente());
        }else{
            System.out.println("No encontro servidor a vaciar");
        }
        
    }
    
    public int servidoresOcupados(){
        int cuenta = 0;
        
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() != null)
                cuenta++;
        }
        
        return cuenta;
    }
    
    /*****************************************************************************************************************************/
    
    //Funcion que muestra/anuncia a un cliente en la interfaz grafica 
    public void AnunciarCliente(Cliente cliente){
        String[] datos = new String[]{
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(cliente.getIT()),
            String.valueOf(cliente.getST())
        };

        //this.ModelCliente.addRow(datos);
        DefaultTableModel model = (DefaultTableModel) this.tablaCliente.getModel();
        model.addRow(datos);
    }
    
    //Funcion que muestra/anuncia un evento en la interfaz grafica
    public void AnunciarEvento(String evento, Cliente cliente){
        String[] datos = new String[]{
            String.valueOf(++nEvento),
            evento,
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(s.getTMd()),
            String.valueOf(s.getTMm()),
            String.valueOf(servidoresOcupados()),
            String.valueOf(Cola.size()),
            String.valueOf(AT),
            String.valueOf(menorDT)
        };

        //this.ModelEvento.addRow(datos);
        DefaultTableModel model = (DefaultTableModel) this.tablaEvento.getModel();
        model.addRow(datos);
    }
    
    public void AnunciarResultados(String descripcion,String resultado){
        DefaultTableModel model = (DefaultTableModel) this.tablaResultados.getModel();
        model.addRow(new String[]{descripcion,resultado});
    }

    /*****************************************************************************************************************************/
    public void calcularEstadisticas(){
        tiempoPromedioAdicional = (float) tiempoAdicional/s.getMaxTMd();
        JLTiempoAdicional.setText(String.valueOf(tiempoPromedioAdicional)+" min");
        
        JLEsperar.setText(String.format("%.2f",calcularProbEsperar())+"%");
        
        JLClientesNoEsperan.setText(String.valueOf(nClientesNoEspera));
        
        int cont = 1;
        for(Servidor servidor: Servidores){
            float porcentajeUtilizado = (float) (servidor.getCountClientes()*100)/nClientesServidos;
            AnunciarResultados("Porcentaje utilizacion servidor " + cont++, String.format("%.2f",porcentajeUtilizado)+"%");
        }
        
        AnunciarResultados("", "");
        
        calcularTiempoPromedioClientesHacenCola();
        calcularWq();
        calcularW();
        
        AnunciarResultados("Tiempo promedio de un cliente en el sistema", String.format("%.2f",W)+" min");
        AnunciarResultados("Tiempo promedio de un cliente en cola", String.format("%.2f",Wq)+" min");
        AnunciarResultados("Tiempo promedio de espera de un cliente que hace cola", String.format("%.2f",tiempoPromedioHaceCola)+" min");
    }
    
    public float calcularProbEsperar(){
        return (float) (nClientesCola*100)/nClientesServidos;
    }
    
    public void calcularTiempoAdicional(){
        if(ultimoTM > s.getMaxTMm())
            tiempoAdicional += ultimoTM-s.getMaxTMm();
    }
    
    public void calcularWq(){
        Wq = (float)(Wq/(nClientesServidos+Cola.size()));
    }
    
    public void calcularTiempoPromedioClientesHacenCola(){
        tiempoPromedioHaceCola = (float)(Wq/nClientesCola);
    }
    
    public void calcularW(){
        W = (float) (W/(nClientesServidos+Cola.size()));
    }
    
    /*****************************************************************************************************************************/
 
    public ArrayList<Tiempo> getTiemposEntreSalidas() {
        return tiemposEntreSalidas;
    }

    public int getNumeroEstacion() {
        return NumeroEstacion;
    }

    public int getnClientes() {
        return nClientes;
    }

    public int getnClientesNoEspera() {
        return nClientesNoEspera;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public ArrayList<Servidor> getServidores() {
        return Servidores;
    }

    public JTable getTablaResultados() {
        return tablaResultados;
    }

    public float getTiempoPromedioAdicional() {
        return tiempoPromedioAdicional;
    }

    public Cliente getEntrante() {
        return entrante;
    }

    public float getW() {
        return W;
    }

    public float getWq() {
        return Wq;
    }

    public float getL() {
        return L;
    }

    public float getLq() {
        return Lq;
    }

    public float getTiempoPromedioHaceCola() {
        return tiempoPromedioHaceCola;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JLClientesNoEsperan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JLEsperar = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JLTiempoAdicional = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEvento = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Cant. Clientes que no esperan:");

        JLClientesNoEsperan.setBackground(new java.awt.Color(255, 255, 255));
        JLClientesNoEsperan.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLClientesNoEsperan.setText("X");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel11.setText("Prob. de esperar:");

        JLEsperar.setBackground(new java.awt.Color(255, 255, 255));
        JLEsperar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEsperar.setText("X");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel17.setText("Tiempo promedio trabajado");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel19.setText("Luego de cerrar:");

        JLTiempoAdicional.setBackground(new java.awt.Color(255, 255, 255));
        JLTiempoAdicional.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTiempoAdicional.setText("X");

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaResultados);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(JLClientesNoEsperan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLEsperar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLTiempoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JLClientesNoEsperan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JLEsperar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(JLTiempoAdicional))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 500));

        tablaCliente.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCliente);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(700, 500));

        tablaEvento.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tablaEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaEvento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLClientesNoEsperan;
    private javax.swing.JLabel JLEsperar;
    private javax.swing.JLabel JLTiempoAdicional;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
