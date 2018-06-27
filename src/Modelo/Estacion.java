/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.Simulacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Valdes
 */
public class Estacion {
    private ArrayList<Servidor> Servidores;
    private ArrayList<Cliente> Cola;
    private final int MinServer = 1;
    private int MaxServer;
    private static int count;
    private int IdEstacion;
    static {
        count = 1;
    }

    public int getIdEstacion() {
        return IdEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        IdEstacion = idEstacion;
    }

    public Estacion(Simulacion windows) {
        Cola = new ArrayList<Cliente>();
        Servidores = new ArrayList<Servidor>();

        int MaxServer = 1;//Integer.parseInt(JOptionPane.showInputDialog(windows,"Por favor ingrese la cantidad de servidores para la estacion: "+(count)+" ","Servidores",JOptionPane.INFORMATION_MESSAGE,null,null,1).toString());
        IdEstacion = count++;

        for (int i = 0; i < MaxServer; i++) {
            Servidores.add(new Servidor());
        }
    }

    public int ServidoresVacio(){
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                return 0;
            }
        }
        return 1;
    } 
    
    public int ServidorVacio(){
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()==null){
                return 1;
            }
        }
        return 0;
    } 

    public ArrayList<Cliente> getCola(){
        return Cola;
    }
    public int getCantidad(){
        int count = 0;
        for (Servidor serv : Servidores){
            if (serv.getCliente() == null){
                count++;
            }
        }
        return count;
    }

    public int CountServidoresOcupados(){
        int cuenta = 0;
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){cuenta++;}
        }
        return cuenta;
    }

    public ArrayList<Servidor> getServidores() {
        return Servidores;
    }

    public int getMaxServer() {
        System.out.println("Estacion " + IdEstacion + " GetMaxServer");
        return MaxServer;
    }

}
