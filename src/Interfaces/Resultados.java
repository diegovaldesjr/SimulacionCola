/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JLabel;

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

    public void setJLCantClienteCola(JLabel JLCantClienteCola) {
        this.JLCantClienteCola = JLCantClienteCola;
    }

    public void setJLClienteHaceCola(JLabel JLClienteHaceCola) {
        this.JLClienteHaceCola = JLClienteHaceCola;
    }

    public void setJLEsperar(float JLEsperar) {
        this.JLEsperar.setText(String.format("%.2f",JLEsperar*100)+"%");
    }

    public void setJLEstaciones(int JLEstaciones) {
        this.JLEstaciones.setText(String.valueOf(JLEstaciones));
    }

    public void setJLL(JLabel JLL) {
        this.JLL = JLL;
    }

    public void setJLLq(JLabel JLLq) {
        this.JLLq = JLLq;
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

    public void setJLTiemoClienteCola(JLabel JLTiemoClienteCola) {
        this.JLTiemoClienteCola = JLTiemoClienteCola;
    }

    public void setJLTiempoAdicional(float JLTiempoAdicional) {
        this.JLTiempoAdicional.setText(String.format("%.2f",JLTiempoAdicional)+" min");
    }

    public void setJLW(JLabel JLW) {
        this.JLW = JLW;
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLNoAtendidos = new javax.swing.JLabel();
        JLEsperar = new javax.swing.JLabel();
        JLCantClienteCola = new javax.swing.JLabel();
        JLTiemoClienteCola = new javax.swing.JLabel();
        JLTiempoAdicional = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLClienteHaceCola = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JLEstaciones14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Resultados de la simulacion.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 11, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Numero de estaciones");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 281, -1));

        JLEstaciones.setBackground(new java.awt.Color(255, 255, 255));
        JLEstaciones.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstaciones.setText("X");
        add(JLEstaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 60, 59, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setText("Tiempo maximo simulacion (dias)");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 281, -1));

        JLTMd.setBackground(new java.awt.Color(255, 255, 255));
        JLTMd.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTMd.setText("X");
        add(JLTMd, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 81, 59, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setText("Tiempo maximo simulacion (minutos)");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 281, -1));

        JLTMm.setBackground(new java.awt.Color(255, 255, 255));
        JLTMm.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTMm.setText("X");
        add(JLTMm, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 102, 59, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Wq");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, 281, -1));

        JLWq.setBackground(new java.awt.Color(255, 255, 255));
        JLWq.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLWq.setText("X");
        add(JLWq, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 175, 59, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setText("W");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 196, 281, -1));

        JLW.setBackground(new java.awt.Color(255, 255, 255));
        JLW.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLW.setText("X");
        add(JLW, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 196, 59, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Lq");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 281, -1));

        JLLq.setBackground(new java.awt.Color(255, 255, 255));
        JLLq.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLLq.setText("X");
        add(JLLq, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 217, 59, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("L");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 238, 281, -1));

        JLL.setBackground(new java.awt.Color(255, 255, 255));
        JLL.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLL.setText("X");
        add(JLL, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 238, 59, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel9.setText("Cant. clientes que no esperan");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 259, 281, -1));

        JLNoEsperan.setBackground(new java.awt.Color(255, 255, 255));
        JLNoEsperan.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLNoEsperan.setText("X");
        add(JLNoEsperan, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 259, 59, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel10.setText("Cant. clientes sin ser atendidos");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 285, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel11.setText("Prob. de esperar");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 301, 285, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel12.setText("Cant. promedio de clientes en cola");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 322, 285, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel13.setText("Tiempo promedio de un cliente en cola");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 343, 285, -1));

        JLNoAtendidos.setBackground(new java.awt.Color(255, 255, 255));
        JLNoAtendidos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLNoAtendidos.setText("X");
        add(JLNoAtendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 280, 59, -1));

        JLEsperar.setBackground(new java.awt.Color(255, 255, 255));
        JLEsperar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEsperar.setText("X");
        add(JLEsperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 301, 59, -1));

        JLCantClienteCola.setBackground(new java.awt.Color(255, 255, 255));
        JLCantClienteCola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLCantClienteCola.setText("X");
        add(JLCantClienteCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 322, 59, -1));

        JLTiemoClienteCola.setBackground(new java.awt.Color(255, 255, 255));
        JLTiemoClienteCola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTiemoClienteCola.setText("X");
        add(JLTiemoClienteCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 343, 59, -1));

        JLTiempoAdicional.setBackground(new java.awt.Color(255, 255, 255));
        JLTiempoAdicional.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLTiempoAdicional.setText("X");
        add(JLTiempoAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 364, 59, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel14.setText("Tiempo promedio de trabajo adicional");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 364, 285, -1));

        JLClienteHaceCola.setBackground(new java.awt.Color(255, 255, 255));
        JLClienteHaceCola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLClienteHaceCola.setText("X");
        add(JLClienteHaceCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 385, 59, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel15.setText("Tiempo promedio de cliente que hace cola");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 385, 285, -1));

        JLEstaciones14.setBackground(new java.awt.Color(255, 255, 255));
        JLEstaciones14.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JLEstaciones14.setText("X");
        add(JLEstaciones14, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 406, 59, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel16.setText("Porcentaje de utilizacion");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 406, 285, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLCantClienteCola;
    private javax.swing.JLabel JLClienteHaceCola;
    private javax.swing.JLabel JLEsperar;
    private javax.swing.JLabel JLEstaciones;
    private javax.swing.JLabel JLEstaciones14;
    private javax.swing.JLabel JLL;
    private javax.swing.JLabel JLLq;
    private javax.swing.JLabel JLNoAtendidos;
    private javax.swing.JLabel JLNoEsperan;
    private javax.swing.JLabel JLTMd;
    private javax.swing.JLabel JLTMm;
    private javax.swing.JLabel JLTiemoClienteCola;
    private javax.swing.JLabel JLTiempoAdicional;
    private javax.swing.JLabel JLW;
    private javax.swing.JLabel JLWq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
