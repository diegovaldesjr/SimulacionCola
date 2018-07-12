/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import Modelo.Probabilidad;
import Modelo.Servidor;
import Modelo.Tiempo;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Valdes
 */
public class Simulacion extends javax.swing.JFrame {
    
    private int TMd;
    private int TMm;
    private int MaxTMd;
    private int MaxTMm;
    
    private int EMaxima;
    private int EMinima;
    
    public static final int Cero = 0;
    public static final int Infinito = 999999999;
    
    private int MaxClientes;
    private int ClientesNoAtendidos;
    
    private Resultados resultados;
    private ArrayList<Estacion> estaciones;
    
    private ArrayList<Tiempo> tiemposEntrellegadas;
    private ArrayList<ArrayList> tiempoSalidas;

    /**
     * Creates new form Simulacion
     */
    public Simulacion(int MaxTMd, int MaxTMh, int EMaxima, int MaxClientes, ArrayList<Tiempo> tiemposEntrellegadas, ArrayList<ArrayList> tiempoSalidas) {
        initComponents();
        this.setLocationRelativeTo(null);

        TMd = 0;
        TMm = 0;
        
        this.MaxTMd = MaxTMd;
        this.MaxTMm = MaxTMh*60;
        
        this.EMinima = 1;
        this.EMaxima = EMaxima;
        
        this.MaxClientes = MaxClientes;
        this.tiemposEntrellegadas = tiemposEntrellegadas;
        this.tiempoSalidas = tiempoSalidas;
        
        //Inicializar las estaciones
        estaciones = new ArrayList<>();
        
        resultados = new Resultados();
        principal.add("Resultados", resultados);
        
        for(int i=0; i< EMaxima; i++){
            int numeroEstacion = i+1;
            Estacion estacion = new Estacion(this, numeroEstacion, this.tiempoSalidas.get(0));
            
            estaciones.add(estacion);
            principal.add("Estacion "+numeroEstacion, estacion);
        }
  
        ClientesNoAtendidos = 0;
        
        resultados.setJLEstaciones(this.EMaxima);
        resultados.setJLTMd(this.MaxTMd);
        resultados.setJLTMm(this.MaxTMm);

        //Iniciar la simulacion
        Start();
    }
    
    /*****************************************************************************************************************************/
    
    private void Start(){
        while(TMd < MaxTMd){
            while(TMm < MaxTMm || clientesEnSistema()){
                for(Estacion estacion: estaciones){
                    estacion.simulacionCola();
                }
            }
            for(Estacion estacion: estaciones){
                estacion.calcularTiempoAdicional();
                estacion.initEstacion();
            }
            this.TMd++;
            this.TMm = 0;
        }

        for(Estacion estacion: estaciones){
            estacion.calcularEstadisticas();
        }
        
        calcularEstadisticas();
    }
    
    /*****************************************************************************************************************************/
    
    public int GetTiempoEntreLLegadas(){
        int rand = GetInterval();
        int cont = 0;
        int tiempo = 0;
        
        for(Tiempo posibleLlegada: tiemposEntrellegadas){
            cont += Math.round(posibleLlegada.getProbabilidad()*100);
            
            if(cont >= rand){
                tiempo = posibleLlegada.getTiempo();
                break;
            }
        }
        
        return tiempo;
    }
    
    public int GetTiempoEntreSalidas(ArrayList<Tiempo> tiemposEntreSalidas){
        int rand = GetInterval();
        int cont = 0;
        int tiempo = 0;
        
        for(Tiempo posibleSalida: tiemposEntreSalidas){
            cont += Math.round(posibleSalida.getProbabilidad()*100);
            
            if(cont >= rand){
                tiempo = posibleSalida.getTiempo();
                break;
            }
        }
        
        return tiempo;
    }
    
    /*****************************************************************************************************************************/
    
    //Si aun hay clientes en el sistema
    private boolean clientesEnSistema(){
        
        for(Estacion estacion: estaciones){
            if(estacion.getnClientes() != 0)
                return true;
        }
        return false;
    }
    
    //Devuelve true si el sistema no esta lleno, sino devuelve falso
    public boolean verificarCapacidad(){
        int nClientes = 0;
        
        for(Estacion estacion: estaciones){
            nClientes += estacion.getnClientes();
        }
        
        if(nClientes < MaxClientes)
            return true;
        else{
            System.out.println("Sistema full");
            ClientesNoAtendidos++;
            return false;
        }
    }
    
    public Cliente pedirCliente(ArrayList<Tiempo> tiemposEntreSalidas){
        return new Cliente(GetTiempoEntreLLegadas(),GetTiempoEntreSalidas(tiemposEntreSalidas));
    }
    
    public void avanzarCliente(Cliente cliente, int numeroEstacion){
        //Si la estacion la cual el cliente esta saliendo no es la ultima
        //Pasa a la siguiente
        if(numeroEstacion < EMaxima){
            int siguiente = numeroEstacion;
            
            cliente.setIT(TMm);
            cliente.setST(GetTiempoEntreSalidas(estaciones.get(siguiente).getTiemposEntreSalidas()));
            estaciones.get(siguiente).Insertar(cliente, false);
        }
    }
    
    public Cliente proximoEnSalir(int NumeroEstacion){
        int indice = NumeroEstacion - 2;
        int ref = Infinito;
        Cliente cliente = null;
        
        for(Servidor servidor: estaciones.get(indice).getServidores()){
            if(servidor.getCliente() != null && ref > servidor.getDT()){
                ref = servidor.getDT();
                cliente = servidor.getCliente();
            }
        }
        
        if(cliente == null)
            cliente = estaciones.get(indice).getEntrante();
        
        return cliente;
    }
    
    /*****************************************************************************************************************************/
    
    private int Random(int max, int min){
        return (int )(Math.random() * max + min);
    }
    
    public int GetInterval() { return Random(100,0); }
    
    public int GetInterval(int max, int min) { return this.Random(max, min); }
    
    /*****************************************************************************************************************************/
    public void calcularEstadisticas(){
        calcularTiempoPromedioAdicional();
        calcularProbEsperar();
        calcularClientesNoEsperan();
        
        resultados.setJLNoAtendidos(ClientesNoAtendidos);
    }
    
    public void calcularClientesNoEsperan(){
        int cont = 0;
        for(Estacion estacion: estaciones){
            cont += estacion.getnClientesNoEspera();
        }
        
        resultados.setJLNoEsperan(cont);
    }
    
    public void calcularProbEsperar(){
        float cont = 0;
        for(Estacion estacion: estaciones){
            cont += estacion.calcularProbEsperar();
        }
        cont /= EMaxima;
        resultados.setJLEsperar(cont);
    }
    
    public void calcularTiempoPromedioAdicional(){
        float cont = 0;
        for(Estacion estacion: estaciones){
            cont += estacion.getTiempoPromedioAdicional();
        }
        cont /= EMaxima;
        resultados.setJLTiempoAdicional(cont);
    }
    
    /*****************************************************************************************************************************/

    public int getTMd() {
        return TMd;
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

    public int getMaxTMd() {
        return MaxTMd;
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
        principal = new javax.swing.JTabbedPane();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane principal;
    // End of variables declaration//GEN-END:variables
}
