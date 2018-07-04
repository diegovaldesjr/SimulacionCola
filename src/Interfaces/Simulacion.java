/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import Modelo.Estacion;
import Modelo.Probabilidad;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Valdes
 */
public class Simulacion extends javax.swing.JFrame {
    public static DefaultTableModel modelCliente;
    public static DefaultTableModel modelEvento;
    
    private int TMd;
    private int TMm;
    private int MaxTMd;
    private int MaxTMm;
    
    private int EMaxima;
    private int EMinima;
    private int SMaxima;
    private int SMinima;
    
    public static final int Cero = 0;
    public static final int Infinito = 9999;
    private int Evento;
    
    private ArrayList<Estacion> estaciones;

    /**
     * Creates new form Simulacion
     */
    public Simulacion(int MaxTMd, int MaxTMm, int EMaxima, int SMaxima) {
        initComponents();

        this.Evento = 0;
        this.TMd = 0;
        this.TMm = 0;
        
        this.MaxTMd = MaxTMd;
        this.MaxTMm = MaxTMm;
        this.EMinima = 1;
        this.EMaxima = EMaxima;
        this.SMinima = 1;
        this.SMaxima = SMaxima;
        
        //Inicializar las estaciones
        estaciones = new ArrayList<>();
        for(int i=0; i< EMaxima; i++){
            int numeroEstacion = i+1;
            estaciones.add(new Estacion(this, SMaxima, numeroEstacion));
        }
        
        //Creacion de modelos para mostrar en las interfaces
        
        this.setLocationRelativeTo(null);
        
        //Modelo para mostrar los clientes
        modelCliente = new DefaultTableModel();
        modelCliente.addColumn("Cliente");
        modelCliente.addColumn("Entrada");
        modelCliente.addColumn("Salida");
        this.tablaCliente.setModel(modelCliente);
        
        //Modelo para mostrar los eventos
        modelEvento = new DefaultTableModel();
        modelEvento.addColumn("# Evento");
        modelEvento.addColumn("Tipo de evento");
        modelEvento.addColumn("# Cliente");
        modelEvento.addColumn("TMd");
        modelEvento.addColumn("TMm");
        modelEvento.addColumn("SS");
        modelEvento.addColumn("WL");
        modelEvento.addColumn("AT");
        modelEvento.addColumn("DT");
        modelEvento.addColumn("Estacion");
        this.tablaEvento.setModel(modelEvento);
        
        //JLDias.setText();
        
        //Mostrar valores en la interfaz
        JLEstaciones.setText(String.valueOf(EMaxima));
        JLMinutos.setText(String.valueOf(MaxTMm));;
        JLDias.setText(String.valueOf(MaxTMd));
    
        //Iniciar la simulacion
        Start();
    }
    
    private void Start(){
        while(TMd < MaxTMd){
            while(TMm < MaxTMm /*&& clienteEnSistema()*/){
                for(Estacion estacion: estaciones){
                    estacion.simulacionCola();
                }
                System.out.println(TMm);
            }
            System.out.println("Chao");
            System.out.println(TMm);
            this.TMd++;
        }
    }
    
    //Si aun hay clientes en el sistema
    private boolean clienteEnSistema(){
        return true;
    }
    
    public Cliente pedirCliente(){
        return new Cliente(Probabilidad.TiempoEntreLlegadas(this.GetInterval()), Probabilidad.TiempoPrimeraEstacion(this.GetInterval()));
    }
    
    public void avanzarCliente(Cliente cliente, int numeroEstacion){
        //Si la estacion la cual el cliente esta saliendo no es la ultima
        //Pasa a la siguiente
        if(numeroEstacion < EMaxima){
            int siguiente = numeroEstacion;
            estaciones.get(siguiente).Insertar(cliente, false);
        }
    }
    
    private int Random(int max, int min){
        return (int )(Math.random() * max + min);
    }

    public int GetTiempoEntreLLegadas(){
        return Random(EMaxima,EMinima);
    }
    public int GetTiempoEntreSalidas(){
        return Random(SMaxima,SMinima);
    }
    
    public int GetInterval() { return Random(100,0); }
    
    public int GetInterval(int max, int min) { return this.Random(max, min); }
    
    //Funcion que muestra/anuncia a un cliente en la interfaz grafica 
    public void AnunciarCliente(Cliente cliente){
        String[] datos = new String[]{
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(cliente.getIT()),
            String.valueOf(cliente.getST())
        };

        modelCliente.addRow(datos);
    }
    
    //Funcion que muestra/anuncia un evento en la interfaz grafica
    public void AnunciarEvento(String evento, Cliente cliente, Estacion estacion){
        String[] datos = new String[]{
            String.valueOf(++Evento),
            evento,
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(TMd),
            String.valueOf(TMm),
            String.valueOf(estacion.servidoresOcupados()),
            String.valueOf(estacion.getCola().size()),
            String.valueOf(estacion.getAT()),
            String.valueOf(estacion.getDT()),
            String.valueOf(estacion.getNumeroEstacion())
        };

        modelEvento.addRow(datos);
    }
    //

    public int getTMm() {
        return TMm;
    }

    public void setTMm(int TMm) {
        this.TMm = TMm;
    }

    public int getMaxTMm() {
        return MaxTMm;
    }

    public void setMaxTMm(int MaxTMm) {
        this.MaxTMm = MaxTMm;
    }
    
    public static DefaultTableModel getModelo(){
        return modelEvento;
    } 

    public static DefaultTableModel getModelCliente() {
        return modelCliente;
    }

    /*
    public static void setJLL(String JLL) {
        Simulacion.JLL.setText(JLL);
    }

    public static void setJLW(String JLW) {
        Simulacion.JLW.setText(JLW);
    }

    public static void setEstacion1(String  estacion1) {
        Simulacion.estacion1.setText( estacion1);
    }

    public static void setEstacion2(String  estacion2) {
        Simulacion.estacion2.setText( estacion2);
    }

    public static void setEstacion3(String  estacion3) {
        Simulacion.estacion3.setText( estacion3);
    }

    public static void setEstacion4(String estacion4) {
        Simulacion.estacion4.setText( estacion4);
    }

    public static void setEstaciones(String estaciones) {
        Simulacion.estaciones.setText(estaciones);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLEstaciones = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLMinutos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLDias = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLDias1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLDias2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JLDias3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JLDias4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        estacion1 = new javax.swing.JLabel();
        estacion2 = new javax.swing.JLabel();
        estacion3 = new javax.swing.JLabel();
        estacion4 = new javax.swing.JLabel();
        porcentajeSistema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEvento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JLWq = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLWs = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLLq = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JLLs = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        JLW = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        JLL = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel12.setText("Wq :");

        jLabel13.setText("X");

        jLabel14.setText("Wq :");

        jLabel15.setText("X");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1040, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1040, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

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

        JLDias1.setBackground(new java.awt.Color(255, 255, 255));
        JLDias1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLDias1.setText("X");

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

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel20.setText("Porcentaje utilizacion");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel21.setText("Sistema:");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel22.setText("Estacion 1:");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel23.setText("Estacion 2:");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel24.setText("Estacion 3:");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel25.setText("Estacion 4:");

        estacion1.setBackground(new java.awt.Color(255, 255, 255));
        estacion1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        estacion1.setText("X");

        estacion2.setBackground(new java.awt.Color(255, 255, 255));
        estacion2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        estacion2.setText("X");

        estacion3.setBackground(new java.awt.Color(255, 255, 255));
        estacion3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        estacion3.setText("X");

        estacion4.setBackground(new java.awt.Color(255, 255, 255));
        estacion4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        estacion4.setText("X");

        porcentajeSistema.setBackground(new java.awt.Color(255, 255, 255));
        porcentajeSistema.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        porcentajeSistema.setText("X");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLDias1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(porcentajeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(JLDias1))
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
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(porcentajeSistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(estacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(estacion2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(estacion3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(estacion4))
                .addContainerGap(13, Short.MAX_VALUE))
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(234, 34));

        jLabel8.setText("Wq :");

        JLWq.setText("X");

        jLabel10.setText("Ws :");

        JLWs.setText("X");

        jLabel16.setText("Lq :");

        JLLq.setText("X");

        jLabel18.setText("Ls :");

        JLLs.setText("X");

        jLabel26.setText("W :");

        JLW.setText("X");

        jLabel27.setText("L :");

        JLL.setText("X");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLWs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLWq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLLq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLLs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(JLLq))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JLWq)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(JLLs))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(JLWs)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(JLL))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(JLW)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLDias;
    private javax.swing.JLabel JLDias1;
    private javax.swing.JLabel JLDias2;
    private javax.swing.JLabel JLDias3;
    private javax.swing.JLabel JLDias4;
    private javax.swing.JLabel JLEstaciones;
    private static javax.swing.JLabel JLL;
    private javax.swing.JLabel JLLq;
    private javax.swing.JLabel JLLs;
    private javax.swing.JLabel JLMinutos;
    private static javax.swing.JLabel JLW;
    private javax.swing.JLabel JLWq;
    private javax.swing.JLabel JLWs;
    private static javax.swing.JLabel estacion1;
    private static javax.swing.JLabel estacion2;
    private static javax.swing.JLabel estacion3;
    private static javax.swing.JLabel estacion4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel porcentajeSistema;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    // End of variables declaration//GEN-END:variables
}
