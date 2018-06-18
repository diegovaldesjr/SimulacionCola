/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import Modelo.Cola;
import Modelo.Estacion;
import Modelo.Global;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Valdes
 */
public class Simulacion extends javax.swing.JFrame {
    public static DefaultTableModel modelCliente;
    public static DefaultTableModel modelEvento;
    public Cola simulacionCola;
    private static Simulacion windows;

    /**
     * Creates new form Simulacion
     */
    public Simulacion(int MaxTMd, int MaxTMm, int EMinima, int EMaxima, int SMinima, int SMaxima) {
        initComponents();
        windows = this;
        //Globa
        this.setLocationRelativeTo(null);
        modelCliente = new DefaultTableModel();
        modelCliente.addColumn("Cliente");
        modelCliente.addColumn("Entrada");
        modelCliente.addColumn("Salida");
        this.tablaCliente.setModel(modelCliente);
        
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
        simulacionCola = new Cola(this,MaxTMd, MaxTMm, EMinima, EMaxima,
            SMinima, SMaxima); 
        
        JLEstaciones.setText(String.valueOf(simulacionCola.getDatos().NumeroEstaciones));
        JLMinutos.setText(String.valueOf(simulacionCola.getDatos().MaxTMm));;
        JLDias.setText(String.valueOf(simulacionCola.getDatos().MaxTMd));
    }
    
    public static void AnunciarCliente(Cliente cliente){
        String[] datos = new String[]{
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(cliente.getEntrada()),
            String.valueOf(cliente.getSalida())
        };

        modelCliente.addRow(datos);
    }
    
    public static void AnunciarEvento(String evento, Cliente cliente, Estacion estacion, Global global){
        String[] datos = new String[]{
            String.valueOf(++global.Evento),
            evento,
            String.valueOf(cliente.getNumeroCliente()),
            String.valueOf(global.TMd),
            String.valueOf(global.TMm),
            String.valueOf(estacion.CountServidoresOcupados()),
            String.valueOf(estacion.getCola().size()),
            String.valueOf(global.AT),
            String.valueOf(global.DT),
            String.valueOf(estacion.getIdEstacion())
        };
        
        
        
        modelEvento.addRow(datos);
    }
    public static void AnunciarCalculo(Cola cola){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        /*calcularTiempoPromediosEnServicios(Estaciones),
            calcularTiempoPromediosEnColas(Estaciones),
            calcularTiempoPromediosEnServicios(Estaciones),
            calcularTiempoPromediosEnColas(Estaciones));*/
        float estacion1,estacion2,estacion3,estacion4;
        try{
            estacion1 =   cola.calcularTiempoPromediosEnColas(cola.getEstaciones().get(0)) + cola.calcularTiempoPromediosEnServicios(cola.getEstaciones().get(0));
        }catch(Exception ex){
            estacion1 = 0;
        }
        try{
            estacion2 =   cola.calcularTiempoPromediosEnColas(cola.getEstaciones().get(1)) + cola.calcularTiempoPromediosEnServicios(cola.getEstaciones().get(1));
        }catch(Exception ex){
            estacion2 = 0;
        }
        try{
            estacion3 =   cola.calcularTiempoPromediosEnColas(cola.getEstaciones().get(2)) + cola.calcularTiempoPromediosEnServicios(cola.getEstaciones().get(2));
        }catch(Exception ex){
            estacion3 = 0;
        }
        try{
            estacion4 =   cola.calcularTiempoPromediosEnColas(cola.getEstaciones().get(3)) + cola.calcularTiempoPromediosEnServicios(cola.getEstaciones().get(3));
        }catch(Exception ex){
            estacion4 = 0;
        }
        System.out.println("estacion "+estacion1);
        System.out.println("estacion "+estacion2);
        System.out.println("estacion "+estacion3);
        System.out.println("estacion "+estacion4);
        
        
        float sistema = estacion1 + estacion2 + estacion3 + estacion4;
        System.out.println("sistema "+sistema);
        
        windows.JLSistema.setText(df.format(sistema)+ "min");
        windows.JLEstacion1.setText(df.format((estacion1/sistema)*100)+ " %");
        windows.JLEstacion2.setText(df.format((estacion2/sistema)*100)+ " %");
        windows.JLEstacion3.setText(df.format((estacion3/sistema)*100)+ " %");
        windows.JLEstacion4.setText(df.format((estacion4/sistema)*100)+ " %");
        windows.JLWq.setText(df.format(cola.calcularTiempoPromediosEnServicios(cola.getEstaciones())));
        windows.JLWs.setText(df.format(cola.calcularTiempoPromediosEnColas(cola.getEstaciones())));
        windows.JLLq.setText(df.format(cola.calcularTiempoPromediosEnColas(cola.getEstaciones())));
        windows.JLLs.setText(df.format(cola.calcularTiempoPromediosEnColas(cola.getEstaciones())));
    }

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
        JLSistema = new javax.swing.JLabel();
        JLEstacion1 = new javax.swing.JLabel();
        JLEstacion2 = new javax.swing.JLabel();
        JLEstacion3 = new javax.swing.JLabel();
        JLEstacion4 = new javax.swing.JLabel();
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

        JLSistema.setBackground(new java.awt.Color(255, 255, 255));
        JLSistema.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLSistema.setText("X");

        JLEstacion1.setBackground(new java.awt.Color(255, 255, 255));
        JLEstacion1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstacion1.setText("X");

        JLEstacion2.setBackground(new java.awt.Color(255, 255, 255));
        JLEstacion2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstacion2.setText("X");

        JLEstacion3.setBackground(new java.awt.Color(255, 255, 255));
        JLEstacion3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstacion3.setText("X");

        JLEstacion4.setBackground(new java.awt.Color(255, 255, 255));
        JLEstacion4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstacion4.setText("X");

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
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLEstacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLEstacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLEstacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLEstacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(JLSistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(JLEstacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(JLEstacion2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(JLEstacion3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(JLEstacion4))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLWs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLWq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
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
    private javax.swing.JLabel JLEstacion1;
    private javax.swing.JLabel JLEstacion2;
    private javax.swing.JLabel JLEstacion3;
    private javax.swing.JLabel JLEstacion4;
    private javax.swing.JLabel JLEstaciones;
    private javax.swing.JLabel JLLq;
    private javax.swing.JLabel JLLs;
    private javax.swing.JLabel JLMinutos;
    private javax.swing.JLabel JLSistema;
    private javax.swing.JLabel JLWq;
    private javax.swing.JLabel JLWs;
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
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    // End of variables declaration//GEN-END:variables
}
