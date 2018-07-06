 
package Interfaces;

import static Interfaces.Simulacion.modelCliente;
import static Interfaces.Simulacion.modelEvento;
import Modelo.Cliente;
import Modelo.Estacion;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class VisorEstacion extends javax.swing.JPanel {
 
    private DefaultTableModel ModelCliente;
    private DefaultTableModel ModelEventos;
    private int Evento;
    private ArrayList<Float> promedioTiempoEnCola = new ArrayList<Float>();
    private ArrayList<Float> promedioTiempoEnServicio = new ArrayList<Float>();
    private Estacion estacion;
    
    
    public VisorEstacion( int EMaxima, int MaxTMm, int MaxTMd) {
        initComponents();
        
        this.estacion = estacion;
        Evento = 0;
        
        //Modelo para mostrar los clientes
        modelCliente = new DefaultTableModel();
        modelCliente.addColumn("Cliente");
        modelCliente.addColumn("Entrada");
        modelCliente.addColumn("Salida");
        this.tablaCliente.setModel(modelCliente);
        ModelCliente = (DefaultTableModel)this.tablaCliente.getModel();
        
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
        this.tablaEvento.setModel(modelEvento);
        ModelEventos = (DefaultTableModel)this.tablaEvento.getModel();
        
        //JLDias.setText();
        
        //Mostrar valores en la interfaz
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
        jLabel26 = new javax.swing.JLabel();
        JLW = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        JLL = new javax.swing.JLabel();
        JLLs = new javax.swing.JLabel();
        JLLq = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLDias1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jLabel26.setText("W :");

        JLW.setText("X");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLWq, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLWs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JLWq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JLWs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(JLW))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setText("Ls :");

        jLabel27.setText("L :");

        JLL.setText("X");

        JLLs.setText("X");

        JLLq.setText("X");

        jLabel16.setText("Lq :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLLq, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLLs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(JLLq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(JLLs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(JLL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Estacion getEstacion() {
        return estacion;
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

        modelCliente.addRow(datos);
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

        modelEvento.addRow(datos);
        
        CalcularWq();
        CalcularWs();
        
        float countWs = 0, countWq = 0;
        for(float i : promedioTiempoEnCola){
            countWq+=i;
        }
        for(float i : promedioTiempoEnServicio){
            countWs+=i;
        }
        countWq/=promedioTiempoEnCola.size();
        countWs/=promedioTiempoEnServicio.size();
        
        JLWq.setText(String.format("%.2f P/Min",countWq));
        JLWs.setText(String.format("%.2f P/Min",countWs));
        JLW.setText(String.format("%.2f P/Min",(Float.parseFloat(String.valueOf(countWs))+Float.parseFloat(String.valueOf(countWq)))));
        
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
    private void CalcularWq(){
        int MaxWL = buscarMaxWL();//verifico la cantidad maxima de clientes que estubieron en la cola
        ArrayList<Float> busqueda = new ArrayList<Float>();
        for(int wl = 0; wl<=MaxWL; wl++){// recorre desde colas vacias hasta el maximo valor de colas
            ArrayList<Integer> tiempo = new ArrayList<>();
            for(int i = 0; i<ModelEventos.getRowCount();i++){//se rrecorre la tabla (Interfaz de eventos) hasta la fila maxima
                int count = 0;
                if(wl == buscarInstanciaWl(i) ){//pregunto si el valor de esa fia es el que se esta buscando
                    for(int j = i + 1; j<ModelEventos.getRowCount();j++){//recorre mientras se mantenga el valor asi verificamos el tiempo en que se mantubo
                        if( buscarInstanciaWl(i)!= buscarInstanciaWl(j) && count>=0){
                            tiempo.add(buscarTiempoWl(j)-buscarTiempoWl(i));
                            count = 0;
                            i = j;
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
    private void CalcularWs(){
        int MaxSs = buscarMaxSs();//verifico la cantidad maxima de clientes que estubieron en la cola
        ArrayList<Float> busqueda = new ArrayList<Float>();
        for(int wl = 0; wl<=MaxSs; wl++){// recorre desde colas vacias hasta el maximo valor de colas
            ArrayList<Integer> tiempo = new ArrayList<>();
            for(int i = 0; i<ModelEventos.getRowCount();i++){//se rrecorre la tabla (Interfaz de eventos) hasta la fila maxima
                int count = 0;
                if(wl == buscarInstanciaSs(i) ){//pregunto si el valor de esa fia es el que se esta buscando
                    for(int j = i + 1; j<ModelEventos.getRowCount();j++){//recorre mientras se mantenga el valor asi verificamos el tiempo en que se mantubo
                        if( buscarInstanciaSs(i)!= buscarInstanciaSs(j) && count>=0){
                            tiempo.add(buscarTiempoSs(j)-buscarTiempoSs(i));
                            count = 0;
                            i = j;
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
    
    
    
    
    
    
    public DefaultTableModel getModelCliente() {
        return ModelCliente;
    }
    public void setModelCliente(DefaultTableModel ModelCliente) {
        this.ModelCliente = ModelCliente;
    }
    public DefaultTableModel getModelEventos() {
        return ModelEventos;
    }
    public void setModelEventos(DefaultTableModel ModelEventos) {
        this.ModelEventos = ModelEventos;
    }
    public JLabel getJLDias() {
        return JLDias;
    }
    public void setJLDias(JLabel JLDias) {
        this.JLDias = JLDias;
    }
    public JLabel getJLDias1() {
        return JLDias1;
    }
    public void setJLDias1(JLabel JLDias1) {
        this.JLDias1 = JLDias1;
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
    public static JLabel getJLL() {
        return JLL;
    }
    public static void setJLL(JLabel JLL) {
        VisorEstacion.JLL = JLL;
    }
    public JLabel getJLLq() {
        return JLLq;
    }
    public void setJLLq(JLabel JLLq) {
        this.JLLq = JLLq;
    }
    public JLabel getJLLs() {
        return JLLs;
    }
    public void setJLLs(JLabel JLLs) {
        this.JLLs = JLLs;
    }
    public JLabel getJLMinutos() {
        return JLMinutos;
    }
    public void setJLMinutos(JLabel JLMinutos) {
        this.JLMinutos = JLMinutos;
    }
    public static JLabel getJLW() {
        return JLW;
    }
    public static void setJLW(JLabel JLW) {
        VisorEstacion.JLW = JLW;
    }
    public JLabel getJLWq() {
        return JLWq;
    }
    public void setJLWq(JLabel JLWq) {
        this.JLWq = JLWq;
    }
    public JLabel getJLWs() {
        return JLWs;
    }
    public void setJLWs(JLabel JLWs) {
        this.JLWs = JLWs;
    }
    public static JLabel getEstacion1() {
        return estacion1;
    }
    public static void setEstacion1(JLabel estacion1) {
        VisorEstacion.estacion1 = estacion1;
    }
    public static JLabel getEstacion2() {
        return estacion2;
    }
    public static void setEstacion2(JLabel estacion2) {
        VisorEstacion.estacion2 = estacion2;
    }
    public static JLabel getPorcentajeSistema() {
        return porcentajeSistema;
    }
    public static void setPorcentajeSistema(JLabel porcentajeSistema) {
        VisorEstacion.porcentajeSistema = porcentajeSistema;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel porcentajeSistema;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaEvento;
    // End of variables declaration//GEN-END:variables

    
}
