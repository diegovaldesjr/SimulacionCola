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
import javax.swing.JTabbedPane;
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
    public static final int Infinito = 999999999;
    private int Evento;
    
    private ArrayList<Estacion> estaciones;

    public static Simulacion simulacion;
    /**
     * Creates new form Simulacion
     */
    public Simulacion(int MaxTMd, int MaxTMm, int EMaxima, int SMaxima) {
        Simulacion.simulacion = this;
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
            VisorEstacion visor = new VisorEstacion(EMaxima,MaxTMm,MaxTMd);
            Estacion estacion = new Estacion(visor, SMaxima, numeroEstacion);
            visor.setEstacion(estacion);
            estaciones.add(estacion);
            TabPanelSimulacion.add("Estacion "+String.valueOf(estacion.getNumeroEstacion()), visor);
        }
        //Creacion de modelos para mostrar en las interfaces
        
        this.setLocationRelativeTo(null);

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

    public int getTMd() {
        return TMd;
    }

    public void setTMd(int TMd) {
        this.TMd = TMd;
    }
    
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

        TabPanelSimulacion = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 600));
        getContentPane().add(TabPanelSimulacion, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPanelSimulacion;
    // End of variables declaration//GEN-END:variables

}
