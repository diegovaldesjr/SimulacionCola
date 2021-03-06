/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Diego Valdes
 */
public class Resultados extends javax.swing.JPanel {

    /**
     * Creates new form Resultados
     */
    public Resultados() {
        initComponents();
    }

    

    public void setJLEsperar(float JLEsperar) {
        this.JLEsperar.setText(String.format("%.2f",JLEsperar)+"%");
    }

    public void setJLEstaciones(int JLEstaciones) {
        this.JLEstaciones.setText(String.valueOf(JLEstaciones));
    }

    public void setJLL(float JLL) {
        this.JLL.setText(String.format("%.2f",JLL));
    }

    public void setJLLq(float JLLq) {
        this.JLLq.setText(String.format("%.2f",JLLq));
    }

    public void setJLNoAtendidos(int JLNoAtendidos) {
        this.JLNoAtendidos.setText(String.valueOf(JLNoAtendidos));
    }

    public void setJLNoEsperan(int JLNoEsperan) {
        this.JLNoEsperan.setText(String.valueOf(JLNoEsperan));
    }

    public void setJLTMd(int JLTMd) {
        this.JLTMd.setText(String.valueOf(JLTMd));
    }

    public void setJLTMm(int JLTMm) {
        this.JLTMm.setText(String.valueOf(JLTMm));
    }

    public void setJLTiempoAdicional(float JLTiempoAdicional) {
        this.JLTiempoAdicional.setText(String.format("%.2f",JLTiempoAdicional)+" min");
    }

    public void setJLW(float JLW) {
        this.JLW.setText(String.format("%.2f",JLW)+" min");
    }

    public void setJLWq(float JLWq) {
        this.JLWq.setText(String.format("%.2f",JLWq)+" min");
    }

    public void setJLUtilizacionServidor(float JLUtilizacionServidor) {
        this.JLUtilizacionServidor.setText(String.format("%.2f",JLUtilizacionServidor)+" min");
    }

    public JLabel getJLHaceCola() {
        return JLHaceCola;
    }

    public void setJLHaceCola(float JLHaceCola) {
        this.JLHaceCola.setText(String.format("%.2f",JLHaceCola)+" min");
    }

    public JLabel getJLL() {
        return JLL;
    }

    public JLabel getJLLq() {
        return JLLq;
    }

    public JLabel getJLW() {
        return JLW;
    }

    public JLabel getJLWq() {
        return JLWq;
    }

    public JLabel getjLabelSugerencia() {
        return jLabelSugerencia;
    }

    public void setjLabelSugerencia(String jLabelSugerencia) {
        this.jLabelSugerencia.setText(jLabelSugerencia);
    }

    public void setjTextAreaOpciones(String jTextAreaOpciones) {
        this.jTextAreaOpciones.setText(jTextAreaOpciones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLEstaciones = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLTMd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLTMm = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLWq = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLW = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLLq = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLNoEsperan = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JLNoAtendidos = new javax.swing.JLabel();
        JLEsperar = new javax.swing.JLabel();
        JLTiempoAdicional = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLHaceCola = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLUtilizacionServidor = new javax.swing.JLabel();
        jLabelSugerencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOpciones = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(1140, 513));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Resultados de la simulacion.");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Numero de estaciones");

        JLEstaciones.setBackground(new java.awt.Color(255, 255, 255));
        JLEstaciones.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstaciones.setText("X");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setText("Tiempo maximo simulacion (dias)");

        JLTMd.setBackground(new java.awt.Color(255, 255, 255));
        JLTMd.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTMd.setText("X");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setText("Tiempo maximo simulacion (minutos)");

        JLTMm.setBackground(new java.awt.Color(255, 255, 255));
        JLTMm.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTMm.setText("X");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Tiempo promedio de clientes en cola");

        JLWq.setBackground(new java.awt.Color(255, 255, 255));
        JLWq.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLWq.setText("X");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setText("Tiempo promedio de clientes en el sistema");

        JLW.setBackground(new java.awt.Color(255, 255, 255));
        JLW.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLW.setText("X");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Cant. promedio de clientes en cola");

        JLLq.setBackground(new java.awt.Color(255, 255, 255));
        JLLq.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLLq.setText("X");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("Cant. promedio de clientes en el sistema");

        JLL.setBackground(new java.awt.Color(255, 255, 255));
        JLL.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLL.setText("X");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel9.setText("Cant. clientes que no esperan");

        JLNoEsperan.setBackground(new java.awt.Color(255, 255, 255));
        JLNoEsperan.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLNoEsperan.setText("X");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel10.setText("Cant. clientes sin ser atendidos");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel11.setText("Prob. de esperar");

        JLNoAtendidos.setBackground(new java.awt.Color(255, 255, 255));
        JLNoAtendidos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLNoAtendidos.setText("X");

        JLEsperar.setBackground(new java.awt.Color(255, 255, 255));
        JLEsperar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEsperar.setText("X");

        JLTiempoAdicional.setBackground(new java.awt.Color(255, 255, 255));
        JLTiempoAdicional.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTiempoAdicional.setText("X");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel14.setText("Tiempo promedio de trabajo adicional");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel12.setText("Tiempo promedio de clientes que hace cola");

        JLHaceCola.setBackground(new java.awt.Color(255, 255, 255));
        JLHaceCola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLHaceCola.setText("X");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel13.setText("Tiempo promedio de utilizacion de servidores");

        JLUtilizacionServidor.setBackground(new java.awt.Color(255, 255, 255));
        JLUtilizacionServidor.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLUtilizacionServidor.setText("X");

        jLabelSugerencia.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSugerencia.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabelSugerencia.setText("Sugerencias:");

        jTextAreaOpciones.setColumns(20);
        jTextAreaOpciones.setRows(5);
        jScrollPane1.setViewportView(jTextAreaOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLTiempoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLHaceCola, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLUtilizacionServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLEsperar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLNoEsperan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLNoAtendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JLW, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLLq, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLTMd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLTMm, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLWq, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLEstaciones)
                        .addComponent(jLabelSugerencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(JLL))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JLNoEsperan))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(JLNoAtendidos))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(JLEsperar))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(JLTiempoAdicional))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(JLHaceCola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(JLUtilizacionServidor))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(JLTMd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(JLTMm))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(JLWq))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(JLW))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JLLq))
                        .addGap(169, 169, 169))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLEsperar;
    private javax.swing.JLabel JLEstaciones;
    private javax.swing.JLabel JLHaceCola;
    private javax.swing.JLabel JLL;
    private javax.swing.JLabel JLLq;
    private javax.swing.JLabel JLNoAtendidos;
    private javax.swing.JLabel JLNoEsperan;
    private javax.swing.JLabel JLTMd;
    private javax.swing.JLabel JLTMm;
    private javax.swing.JLabel JLTiempoAdicional;
    private javax.swing.JLabel JLUtilizacionServidor;
    private javax.swing.JLabel JLW;
    private javax.swing.JLabel JLWq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSugerencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOpciones;
    // End of variables declaration//GEN-END:variables
}
