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

    public Estacion(Simulacion windows, int MaxServer) {
        //Cola de la estacion
        Cola = new ArrayList<Cliente>();
        
        //Servidores de la estacion
        Servidores = new ArrayList<Servidor>();
        this.MaxServer = MaxServer;
        
        for (int i = 0; i < MaxServer; i++) {
            Servidores.add(new Servidor());
        }
        
        //Numero de estacion
        IdEstacion = count++;
    }
    
    public int getIdEstacion() {
        return IdEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        IdEstacion = idEstacion;
    }

    //Retorna 1 si todos los servidores estan vacios
    //Retorna 0 si algun servidor llega a estar ocupado
    public int ServidoresVacio(){
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                return 0;
            }
        }
        return 1;
    }
    
    //Retorna 1 si alguno de los servidores esta vacios
    //Retorna 0 si todos servidores llegan a estar ocupado
    public int ServidorVacio(){
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

    public ArrayList<Cliente> getCola(){
        return Cola;
    }

    //Devuelve el numero de servidores que estan atendiendo a un cliente
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
