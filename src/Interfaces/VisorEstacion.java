 
package Interfaces;

import static Interfaces.Simulacion.modelCliente;
import static Interfaces.Simulacion.modelEvento;
import Modelo.Cliente;
import Modelo.Estacion;
import Modelo.Servidor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
 
public class VisorEstacion extends javax.swing.JPanel {
 
    private DefaultTableModel ModelClientes;
    private DefaultTableModel ModelEventos;
    private DefaultTableModel ModelResultados;
    private int Evento;
    private ArrayList<Float> promedioTiempoEnCola = new ArrayList<Float>();
    private ArrayList<Float> promedioTiempoEnServicio = new ArrayList<Float>();
    private float promedioPersornasEnCola;
    private float promedioPersornasEnServicio;
    private Estacion estacion;
    
    
    public VisorEstacion( int EMaxima, int MaxTMm, int MaxTMd) {
        initComponents();
        
        this.estacion = estacion;
        Evento = 0;
        initTablaClientes();
        initTablaEventos();
        initTablaResultados();
        JLEstaciones.setText(String.valueOf(EMaxima));
        JLMinutos.setText(String.valueOf(MaxTMm));;
        JLDias.setText(String.valueOf(MaxTMd));
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLEstaciones = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLMinutos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLDias = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLClientesNoEsperan = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLDias2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JLDias3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JLDias4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEvento = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1127, 622));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel1.setText("Numero de estaciones:");

        JLEstaciones.setBackground(new java.awt.Color(255, 255, 255));
        JLEstaciones.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstaciones.setText("X");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setText("Max Minutos/Dias:");

        JLMinutos.setBackground(new java.awt.Color(255, 255, 255));
        JLMinutos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLMinutos.setText("X");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setText("Max Numero de Dias:");

        JLDias.setBackground(new java.awt.Color(255, 255, 255));
        JLDias.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLDias.setText("X");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Cant. Cliente que no esperan:");

        JLClientesNoEsperan.setBackground(new java.awt.Color(255, 255, 255));
        JLClientesNoEsperan.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLClientesNoEsperan.setText("X");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel9.setText("Cant. Cliente no atendidos:");

        JLDias2.setBackground(new java.awt.Color(255, 255, 255));
        JLDias2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLDias2.setText("X");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel11.setText("Prob. Clientes esperando:");

        JLDias3.setBackground(new java.awt.Color(255, 255, 255));
        JLDias3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLDias3.setText("X");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel17.setText("Tiempo promedio trabajado");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel19.setText("Luego de cerrar:");

        JLDias4.setBackground(new java.awt.Color(255, 255, 255));
        JLDias4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLDias4.setText("X");

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLDias, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLDias2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLDias3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLDias4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(JLClientesNoEsperan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLEstaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JLMinutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JLDias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JLClientesNoEsperan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JLDias2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JLDias3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(JLDias4))
                .addGap(18, 18, 18)
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

    public void initTablaEventos(){
        //Modelo para mostrar los clientes
        DefaultTableModel modelCliente = new DefaultTableModel();
        modelCliente.addColumn("Cliente");
        modelCliente.addColumn("Entrada");
        modelCliente.addColumn("Salida");
        this.tablaCliente.setModel(modelCliente);
        ModelClientes = (DefaultTableModel)this.tablaCliente.getModel();
    }
    public void initTablaClientes(){
        //Modelo para mostrar los eventos
        DefaultTableModel modelEvento = new DefaultTableModel();
        modelEvento.addColumn("# Evento");
        modelEvento.addColumn("Tipo de evento");
        modelEvento.addColumn("# Cliente");
        modelEvento.addColumn("TMd");
        modelEvento.addColumn("TMm");
        modelEvento.addColumn("SS");
        modelEvento.addColumn("WL");
        modelEvento.addColumn("AT");
        modelEvento.addColumn("DT");
        this.tablaEvento.setModel(modelEvento);
        ModelEventos = (DefaultTableModel)this.tablaEvento.getModel();
    }
    public void initTablaResultados(){
        //Modelo para la tabla de resultados
        DefaultTableModel modelResultado = new DefaultTableModel();
        modelResultado.addColumn("Tipo");
        modelResultado.addColumn("Resultado");
        modelResultado.addColumn("Parametro");
        this.tablaResultados.setModel(modelResultado);
        this.ModelResultados = (DefaultTableModel) this.tablaResultados.getModel();
        
        this.tablaResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel columnModel = this.tablaResultados.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(300);
    }
    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
    
    //Funcion que muestra/anuncia a un cliente en la interfaz grafica 
    public void AnunciarCliente(Cliente cliente){
        String[] datos = new String[]{
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(cliente.getIT()),
            String.valueOf(cliente.getST())
        };
        ModelClientes.addRow(datos);
    }
    
    //Funcion que muestra/anuncia un evento en la interfaz grafica
    public void AnunciarEvento(String evento, Cliente cliente, Estacion estacion, Simulacion s){
        String[] datos = new String[]{
            String.valueOf(++Evento),
            evento,
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(s.getTMd()),
            String.valueOf(s.getTMm()),
            String.valueOf(estacion.servidoresOcupados()),
            String.valueOf(estacion.getCola().size()),
            String.valueOf(estacion.getAT()),
            String.valueOf(estacion.getDT())
        };

        ModelEventos.addRow(datos);
        
    }
    public void CalcularTodo(){
        
        initTablaResultados();
        CalcularWq();
        CalcularWs();
        CalcularLs();
        CalcularLq();
        
        float countWs = 0.0f, countWq = 0.0f;
        
        for(float i : promedioTiempoEnCola){
            countWq+=i;
        }
        for(float i : promedioTiempoEnServicio){
            countWs+=i;
        }
        countWq/=promedioTiempoEnCola.size();
        countWs/=promedioTiempoEnServicio.size();
        
        AnunciarResultados("Wq",String.format("%.2f",countWq), "Minutos");
        AnunciarResultados("Ws",String.format("%.2f",countWs), "Minutos");
        AnunciarResultados("W",String.format("%.2f",countWs+countWq), "Minutos");
        
        AnunciarResultados("Lq",String.format("%.2f",promedioPersornasEnCola), "Personas");
        AnunciarResultados("Ls",String.format("%.2f",promedioPersornasEnServicio), "Personas");
        AnunciarResultados("L",String.format("%.2f",promedioPersornasEnServicio+promedioPersornasEnCola), "Personas");
        AnunciarResultados("------------","------------","------------");
        int count = Simulacion.Cero ;
        int clientes = 0;
        for(Servidor server : this.estacion.getServidores()){
            AnunciarResultados("S("+(++count)+")",String.valueOf(server.getCountClientes()), "Clientes");
            clientes+=server.getCountClientes();
        }
        JLClientesNoEsperan.setText(String.valueOf(clientes-this.estacion.getnClientesCola()));

        AnunciarResultados("------------","------------","------------");
        AnunciarResultados("C",String.valueOf(this.estacion.getnClientesCola()), "Personas");
        AnunciarResultados("------------","------------","------------");
        count = Simulacion.Cero ;
        for(float serveTime : promedioTiempoEnServicio){
            AnunciarResultados("Ts("+(count++)+")",String.format("%.2f",serveTime), "Minutos");
        }
        AnunciarResultados("------------","------------","------------");
        count = Simulacion.Cero ;
        for(float colaTime : promedioTiempoEnCola){
            AnunciarResultados("Tc("+(count++)+")",String.format("%.2f",colaTime), "Minutos");
        }
        AnunciarResultados("------------","------------","------------");
        count = Simulacion.Cero ;
        for(float serveTime : calcularUsoWs()){
            AnunciarResultados("Ps("+(count++)+")",String.format("%.2f",100*(serveTime/ModelEventos.getRowCount()))+"%", "Probabilidad / Clientes / Servidos");
        }
        AnunciarResultados("------------","------------","------------");
        count = Simulacion.Cero ;
        for(float colaTime : calcularUsoWq()){
            AnunciarResultados("Pc("+(count++)+")",String.format("%.2f",100*(colaTime/ModelEventos.getRowCount()))+"%", "Probabilidad / Clientes / Colas");
        }/**/
    }
    
    
    public void AnunciarResultados(String tipo,String resultado, String parametro){
        ModelResultados.addRow(new String[]{tipo,resultado,parametro});
    }
    private void CalcularW() {

        int estacion = 1;
        ArrayList<Integer> calculos = new ArrayList<Integer>();
        for(int cliente = 0; cliente<Cliente.getCuentaCliente(); cliente++){
            int count = 0;

            int entrada = 0;
            int salida = 0;

            for(int ciclo = 1; ciclo<ModelEventos.getRowCount(); ciclo++){

                if( buscarEntradaW(ModelEventos,ciclo,cliente)!=0){
                    entrada = buscarEntradaW(ModelEventos,ciclo,cliente);
                    break;
                }
            }
            for(int ciclo = 0; ciclo<ModelEventos.getRowCount(); ciclo++){
                if(buscarSalidaW(ModelEventos,ciclo,cliente)!=0){
                    salida = buscarSalidaW(ModelEventos,ciclo,cliente);
                    break;
                }
            }
            if(entrada<salida){
                calculos.add(salida-entrada);
            }
        }
            

    }

    private int buscarEntradaW(DefaultTableModel modelo,int fila,int cliente){
        int columna1 = 1, columna2 = 2, columna4 = 4;
        if(modelo.getValueAt(fila, columna1).toString()=="Entrada" && Integer.parseInt(modelo.getValueAt(fila, columna2).toString()) == cliente){
            return Integer.parseInt(ModelEventos.getValueAt(fila, columna4).toString());
        }
        return 0;
    }
    
    private int buscarSalidaW(DefaultTableModel modelo,int fila,int cliente){
        int columna1 = 1, columna2 = 2, columna4 = 4;
        if(modelo.getValueAt(fila, columna1).toString()=="Salida" && Integer.parseInt(modelo.getValueAt(fila, columna2).toString()) == cliente){
            return Integer.parseInt(modelo.getValueAt(fila, columna4).toString());
        }
        return 0;
    }
/*##############################################################################################################################################################*/
    private ArrayList<Integer> calcularUsoWq(){
        int MaxWL = buscarMaxWL();//verifico la cantidad maxima de clientes que estubieron en la cola
        int columna6 = 6;
        ArrayList<Integer> busqueda = new ArrayList<Integer>();
        for(int wl = 0; wl<=MaxWL; wl++){// recorre desde colas vacias hasta el maximo valor de colas
            int count = 0;
             for(int i = 0 ; i<ModelEventos.getRowCount() ; i++){
                 if( wl == Integer.parseInt(ModelEventos.getValueAt(i, columna6).toString())){
                     count++;
                 }
             }
             busqueda.add(count);
        }
        return busqueda;
    }
    private void CalcularWq(){
        int MaxWL = buscarMaxWL();//verifico la cantidad maxima de clientes que estubieron en la cola
        ArrayList<Float> busqueda = new ArrayList<Float>();
        for(int wl = 0; wl<=MaxWL; wl++){// recorre desde colas vacias hasta el maximo valor de colas
            ArrayList<Integer> tiempo = new ArrayList<>();
            for(int i = 0; i<ModelEventos.getRowCount();i++){//se recorre la tabla (Interfaz de eventos) hasta la fila maxima
                int count = 0;
                if(wl == buscarInstanciaWl(i) ){//pregunto si el valor de esa fia es el que se esta buscando
                    for(int j = i + 1; j<ModelEventos.getRowCount();j++){//recorre mientras se mantenga el valor asi verificamos el tiempo en que se mantubo
                        if( (buscarInstanciaWl(i)!= buscarInstanciaWl(j) || j == ModelEventos.getRowCount()-1) && count>=0){
                            tiempo.add(buscarTiempoWl(j)-buscarTiempoWl(i));
                            count = 0;
                            i = j;
                        }else {
                            count++;
                        }
                    }
                }
            }
            if(tiempo.size()==Simulacion.Cero){
                busqueda.add(Float.parseFloat(String.valueOf(Simulacion.Cero)));
            }else{
                float count = 0;
                for(int sumador : tiempo){
                    count+=sumador;
                }
                busqueda.add(count/tiempo.size());
            }
        }
        promedioTiempoEnCola = busqueda;
    }
    
    private int buscarInstanciaWl(int fila){
        int columna6 = 6;
        return Integer.parseInt(ModelEventos.getValueAt(fila, columna6).toString());
    }
    private int buscarTiempoWl(int fila){
        int columna4 = 4;
        return Integer.parseInt(ModelEventos.getValueAt(fila, columna4).toString());

    }
    private int buscarMaxWL() {
        int columna = 6;
        int max = (-1)*Simulacion.Infinito;
        for(int fila = 0; fila<ModelEventos.getRowCount();fila++){
            if(Integer.parseInt(ModelEventos.getValueAt(fila, columna).toString()) > max){
                max = Integer.parseInt(ModelEventos.getValueAt(fila, columna).toString());
            }
        }
                return max;
    }
    /*##############################################################################################################################################################*/
    private ArrayList<Integer> calcularUsoWs(){
        int MaxWS = buscarMaxWS();//verifico la cantidad maxima de clientes que estubieron en la cola
        int columna5 = 5;
        ArrayList<Integer> busqueda = new ArrayList<Integer>();
        for(int ws = 0; ws<=MaxWS; ws++){// recorre desde colas vacias hasta el maximo valor de colas
            int count = 0;
             for(int i = 0 ; i<ModelEventos.getRowCount() ; i++){
                 if( ws == Integer.parseInt(ModelEventos.getValueAt(i, columna5).toString())){
                     count++;
                 }
             }
             busqueda.add(count);
        }
        return busqueda;
    }
    private int buscarMaxWS() {
        int columna = 5;
        int max = (-1)*Simulacion.Infinito;
        for(int fila = 0; fila<ModelEventos.getRowCount();fila++){
            if(Integer.parseInt(ModelEventos.getValueAt(fila, columna).toString()) > max){
                max = Integer.parseInt(ModelEventos.getValueAt(fila, columna).toString());
            }
        }
                return max;
    }
    
    private void CalcularWs(){
        int MaxSs = buscarMaxSs();//verifico la cantidad maxima de clientes que estubieron en la cola
        ArrayList<Float> busqueda = new ArrayList<Float>();
        for(int wl = 0; wl<=MaxSs; wl++){// recorre desde colas vacias hasta el maximo valor de colas
            ArrayList<Integer> tiempo = new ArrayList<>();
            for(int i = 0; i<ModelEventos.getRowCount();i++){//se rrecorre la tabla (Interfaz de eventos) hasta la fila maxima
                int count = 0;
                if(wl == buscarInstanciaSs(i) ){//pregunto si el valor de esa fia es el que se esta buscando
                    for(int j = i + 1; j<ModelEventos.getRowCount();j++){//recorre mientras se mantenga el valor asi verificamos el tiempo en que se mantubo
                        if( (buscarInstanciaSs(i)!= buscarInstanciaSs(j)  || j == ModelEventos.getRowCount()-1) && count>=0){
                            tiempo.add(buscarTiempoSs(j)-buscarTiempoSs(i));
                            count = 0;
                            if(j == ModelEventos.getRowCount()-1){
                                i = j+1;
                            }else{
                                i = j;
                            }
                            
                        }else{
                            count++;
                        }
                    }
                }
            }
            if(tiempo.size()==Simulacion.Cero){
                busqueda.add(Float.parseFloat(String.valueOf(Simulacion.Cero)));
            }else{
                float count = 0;
                for(int sumador : tiempo){
                    count+=sumador;
                }
                busqueda.add(count/tiempo.size());
            }
        }
        promedioTiempoEnServicio = busqueda;
    }
    
    private int buscarInstanciaSs(int fila){
        int columna5 = 5;
        return Integer.parseInt(ModelEventos.getValueAt(fila, columna5).toString());
    }
    private int buscarTiempoSs(int fila){
        int columna4 = 4;
        return Integer.parseInt(ModelEventos.getValueAt(fila, columna4).toString());

    }
    private int buscarMaxSs() {
        int columna5 = 5;
        int max = (-1)*Simulacion.Infinito;
        for(int fila = 0; fila<ModelEventos.getRowCount();fila++){
            if(Integer.parseInt(ModelEventos.getValueAt(fila, columna5).toString()) > max){
                max = Integer.parseInt(ModelEventos.getValueAt(fila, columna5).toString());
            }
        }
                return max;
    }

    public void CalcularLs(){
        ArrayList<Servidor> servidores = estacion.getServidores();
        promedioPersornasEnServicio = 0;
        for(Servidor server : servidores){
            promedioPersornasEnServicio += server.getCountClientes();
        }
        promedioPersornasEnServicio *= ModelClientes.getRowCount();
        promedioPersornasEnServicio /= BuscarTiempo();
    }
    public void CalcularLq(){
        promedioPersornasEnCola = estacion.getnClientesCola();
        promedioPersornasEnCola *= ModelClientes.getRowCount();
        promedioPersornasEnCola /= BuscarTiempo();
    }
    private int BuscarTiempo() {
        int columna4 = 4, columna3 = 3;
        int TMm = Integer.parseInt(ModelEventos.getValueAt(ModelEventos.getRowCount()-1, columna4).toString());
        int TMd =Integer.parseInt(ModelEventos.getValueAt(ModelEventos.getRowCount()-1, columna3).toString());
        
        return TMm*(TMd+1);
    }

    public float getW(){
        int flia2 = 2;
        int columna0 = 0;
        return Float.parseFloat(ModelResultados.getValueAt(flia2,columna0).toString());
    }
    public float getL(){
        int flia5 = 5;
        int columna0 = 0;
        return Float.parseFloat(ModelResultados.getValueAt(flia5,columna0).toString());
    }
    private int buscarMaxTD() {
        int columna5 = 5;
        int max = (-1)*Simulacion.Infinito;
        for(int fila = 0; fila<ModelEventos.getRowCount();fila++){
            if(Integer.parseInt(ModelEventos.getValueAt(fila, columna5).toString()) > max){
                max = Integer.parseInt(ModelEventos.getValueAt(fila, columna5).toString());
            }
        }
                return max;
    }
    
    public JLabel getJLDias() {
        return JLDias;
    }
    public void setJLDias(JLabel JLDias) {
        this.JLDias = JLDias;
    }
    public JLabel getJLDias1() {
        return JLClientesNoEsperan;
    }
    public void setJLDias1(JLabel JLDias1) {
        this.JLClientesNoEsperan = JLDias1;
    }
    public JLabel getJLDias2() {
        return JLDias2;
    }
    public void setJLDias2(JLabel JLDias2) {
        this.JLDias2 = JLDias2;
    }
    public JLabel getJLDias3() {
        return JLDias3;
    }
    public void setJLDias3(JLabel JLDias3) {
        this.JLDias3 = JLDias3;
    }
    public JLabel getJLDias4() {
        return JLDias4;
    }
    public void setJLDias4(JLabel JLDias4) {
        this.JLDias4 = JLDias4;
    }
    public JLabel getJLEstaciones() {
        return JLEstaciones;
    }
    public void setJLEstaciones(JLabel JLEstaciones) {
        this.JLEstaciones = JLEstaciones;
    }
    public JLabel getJLMinutos() {
        return JLMinutos;
    }
    public void setJLMinutos(JLabel JLMinutos) {
        this.JLMinutos = JLMinutos;
    }
    
    public JTable getTablaCliente() {
        return tablaCliente;
    }
    public void setTablaCliente(JTable tablaCliente) {
        this.tablaCliente = tablaCliente;
    }
    public JTable getTablaEvento() {
        return tablaEvento;
    }
    public void setTablaEvento(JTable tablaEvento) {
        this.tablaEvento = tablaEvento;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLClientesNoEsperan;
    private javax.swing.JLabel JLDias;
    private javax.swing.JLabel JLDias2;
    private javax.swing.JLabel JLDias3;
    private javax.swing.JLabel JLDias4;
    private javax.swing.JLabel JLEstaciones;
    private javax.swing.JLabel JLMinutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables

    

    
}
