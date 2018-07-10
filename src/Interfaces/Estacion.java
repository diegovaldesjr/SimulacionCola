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
import java.util.ArrayList;
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
    private int DT;
    
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
    
    private int W;
    private int Wq;
    private int Ws;
    private int L;
    private int Lq;
    private int Ls;
    
    /**
     * Creates new form Estacion
     */
    public Estacion(Simulacion s, int MaxServer, int NumeroEstacion) {
        initComponents();
        
        this.s = s;
        
        //Cola de la estacion
        Cola = new ArrayList<Cliente>();
        
        //Servidores de la estacion
        Servidores = new ArrayList<Servidor>();
        this.MaxServer = MaxServer;
        
        for (int i = 0; i < MaxServer; i++) {
            Servidores.add(new Servidor());
        }
        
        //Numero de estacion
        this.NumeroEstacion = NumeroEstacion;

        this.nEvento = 0;
        this.tiempoAdicional = 0;
        
        nClientesCola = 0;
        nClientesServidos = 0;
        nClientesNoEspera = 0;
        
        W = 0;
        Wq = 0;
        Ws = 0;
        L = 0;
        Lq = 0;
        Ls = 0;
        
        initTablaEventos();
        initTablaClientes();
        initTablaResultados();
        initEstacion();
        
    }
    
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
        ModelResultados.addColumn("Tipo");
        ModelResultados.addColumn("Resultado");
        ModelResultados.addColumn("Parametro");
        this.tablaResultados.setModel(ModelResultados);
        
        this.tablaResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel columnModel = this.tablaResultados.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(300);
    }
    
    public void initEstacion(){
        AT = 0;
        DT = Simulacion.Infinito;
        
        this.ultimoTM = 0;
        
        for(Servidor servidor: Servidores){
            servidor.setCliente(null);
        }
        
        nClientes = 0;
        
        if(NumeroEstacion == 1)
            entrante = new Cliente(Cero, Probabilidad.TiempoPrimeraEstacion(s.GetInterval()));
        else
            entrante = null;
    }
    
    public void simulacionCola(){
        //Solo se generan cliente para entrar en la primera estacion
        if(AT < DT && NumeroEstacion == 1 && s.getTMm() < s.getMaxTMm() && s.verificarCapacidad()){
            //Anuncia al cliente a entrar en el sistema
            AnunciarCliente(entrante);
            
            //Actualiza TM
            s.setTMm(AT);

            Insertar(entrante, false);
            
            entrante = nuevo;
        }else if(nClientes != Cero && !ServidoresVacios()){
            System.out.println("nClientes "+nClientes+" estacion "+NumeroEstacion);
            //Actualizo TM
            s.setTMm(DT);

            //Llamo funcion que saca a cliente del servidor que dejara de ser atendido
            VaciarServidor();
        }
        ultimoTM = s.getTMm();
    }

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
    
    //Retorna 1 si alguno de los servidores esta vacios
    //Retorna 0 si todos servidores llegan a estar ocupado
    public int ServidorDisponible(){
        int estado = 0;
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                estado++;
            }
        }
        
        if(estado == MaxServer)
            return 0;
        else
            return 1;
    }
    
    //Inserta un en la estacion, verificar si puede ser atendido o si tendra que
    //Esperar en cola
    public void Insertar(Cliente cliente, boolean clienteEnCola){
        //Registrar que cuenta de clientes que han pasado por el servidor
        if(!clienteEnCola)
            nClientes++;
        
        //Si algun servidor esta desocupado en la primera estacion
        if(ServidorDisponible() == 1){
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
        
        if(NumeroEstacion == 1 || !clienteEnCola){
            //Se genera el proximo cliente a llegar en la siguiente iteracion
            nuevo = s.pedirCliente();
        }else{
            //Pedir proximo a entrar
            nuevo = s.proximoEnSalir(NumeroEstacion);
            System.out.println("Otra estacion");
        }
            
        //nuevo tiene que pedir el proximo a salir de la estacion anterior
        

        //Anuncio evento de entrada
        if(!clienteEnCola){
            //Actualizo AT
            AT = s.getTMm() + nuevo.getIT();
            if(s.getTMm() < s.getMaxTMm())
                AnunciarEvento("Entrada",cliente);
        }
        
        //System.out.println("Entrada "+entrante.getIT());
        //System.out.println("Salida "+entrante.getST());
        System.out.println("Entrada sig"+nuevo.getIT());
        System.out.println("Salida sig"+nuevo.getST());
        System.out.println("AT "+AT);
        System.out.println("DT "+DT);
        System.out.println("TM "+s.getTMm());
        System.out.println("Cola "+Cola.size());
        System.out.println("----------------------------------------------------");
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
        
        //Se genera el tiempo en que va a dejar de ser atendido
        cliente.setSalidaEstacion(s.getTMm() + cliente.getST());
        System.out.println("Saldra en el TM " + cliente.getSalidaEstacion());
        
        //Actualizo DT
        DT = s.getTMm() + cliente.getST();
    }
    
    //Ejecuta una salida de un cliente de la estacion y si hay una siguiente
    //Lo inserta en ella
    private void VaciarServidor(){
        Servidor servidorAVaciar = null;
        Cliente cliente;
        
        //Se busca por las estaciones el servidor cuyo cliente tenga su tiempo de salida
        //Igual al tiempo actual
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() != null && servidor.getCliente().getSalidaEstacion() == s.getTMm()){
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
                DT = s.getTMm() + cliente.getST();
                Insertar(primeroEnCola, true);
            }else{
                //Actualizar DT a infito para que llegue otro cliente en la siguiente iteracion
                DT = Simulacion.Infinito;
            }
            AnunciarEvento("Salida", cliente);
            
            nClientes--;
            s.avanzarCliente(cliente, NumeroEstacion);
            
            
            System.out.println("Sale de la estacion "+ NumeroEstacion + " el cliente" + cliente.getNumeroCliente());
        }else{
            System.out.println("No encontro servidor a vaciar");
            System.out.println(s.getTMm());
            System.out.println(DT);
            System.out.println(AT);
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
            String.valueOf(DT),
            String.valueOf(NumeroEstacion)
        };

        //this.ModelEvento.addRow(datos);
        DefaultTableModel model = (DefaultTableModel) this.tablaEvento.getModel();
        model.addRow(datos);
    }
    
    public void AnunciarResultados(String tipo,String resultado, String parametro){
        //this.ModelResultados.addRow(new String[]{tipo,resultado,parametro});
        DefaultTableModel model = (DefaultTableModel) this.tablaResultados.getModel();
        model.addRow(new String[]{tipo,resultado,parametro});
    }

    public int getnClientes() {
        return nClientes;
    }

    public int getnClientesNoEspera() {
        return nClientesNoEspera;
    }

    public float probEsperar(){
        return (float) nClientesCola/nClientesServidos;
    }
    
    public void calcularTiempoAdicional(){
        if(ultimoTM > s.getMaxTMm())
            tiempoAdicional += ultimoTM-s.getMaxTMm();
    }
    
    public void resultados(){
        JLTiempoAdicional.setText(String.valueOf(tiempoAdicional)+" min");
        
        JLEsperar.setText(String.format("%.2f",probEsperar()*100)+"%");
        JLClientesNoEsperan.setText(String.valueOf(nClientesNoEspera));
        
        int cont = 1;
        for(Servidor servidor : Servidores){
            float porcentajeUso = (float) servidor.getCountClientes()/nClientesServidos;
            AnunciarResultados("S("+cont+")", String.format("%.2f", porcentajeUso*100)+"%", "Porcentaje uso servidor "+cont++);
        }
        AnunciarResultados("------------","------------","------------");
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public ArrayList<Servidor> getServidores() {
        return Servidores;
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
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLClientesNoEsperan1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEvento = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Cant. Cliente que no esperan:");

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

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("Tiempo promedio cliente");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel10.setText("que hace cola:");

        JLClientesNoEsperan1.setBackground(new java.awt.Color(255, 255, 255));
        JLClientesNoEsperan1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLClientesNoEsperan1.setText("X");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLClientesNoEsperan1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(JLClientesNoEsperan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLEsperar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17))
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
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JLClientesNoEsperan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(55, 55, 55)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel JLClientesNoEsperan1;
    private javax.swing.JLabel JLEsperar;
    private javax.swing.JLabel JLTiempoAdicional;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
