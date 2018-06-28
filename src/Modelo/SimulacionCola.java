/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.Simulacion;
import java.util.ArrayList;

/**
 *
 * @author Diego Valdes
 */
public class SimulacionCola {
    private ArrayList<Estacion> estaciones;
    private Global datos;

    public SimulacionCola(Simulacion windows,int MaxTMd, int MaxTMm, int EMaxima,
            int SMaxima) {
        datos = new Global(MaxTMd, MaxTMm, EMaxima, SMaxima);
        estaciones = new ArrayList<>();
        for(int i=0; i< EMaxima; i++)
            estaciones.add(new Estacion(windows, SMaxima));
        
        Start();
    }
    
    public Global getDatos() {
        return datos;
    }
    
    public void Start(){
        System.out.println("Inicia simulacion");

        datos.TMm = datos.Cero;
        datos.TMd = datos.Cero;

        datos.AT = datos.Cero;
        datos.DT = datos.infinito;

        Cliente entrante;
        Cliente nuevo;
        
        while(datos.TMd < datos.MaxTMd){
            entrante = new Cliente(datos.Cero, Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
            
            while(datos.TMm < datos.MaxTMm){
                if(datos.AT < datos.DT){
                    Simulacion.AnunciarCliente(entrante);
                    datos.TMm = datos.AT;
                    
                    System.out.println("Entrada" + entrante.getIT());
                    System.out.println("Salida" + entrante.getST());
                    
                    if(estaciones.get(0).ServidoresVacio() == 1){
                        Insertar(estaciones.get(0), entrante);
                    }else{
                        System.out.println("Añadir cliente a Cola");
                        estaciones.get(0).getCola().add(entrante);
                    }
                    nuevo = new Cliente(Probabilidad.TiempoEntreLlegadas(datos.GetInterval()), Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
                    datos.AT = datos.TMm + nuevo.getIT();
                    
                    Simulacion.AnunciarEvento("Entrada",entrante, estaciones.get(0), datos);
                    
                    System.out.println("Entrada sig " + nuevo.getIT());
                    System.out.println("Salida sig " + nuevo.getST());
                    System.out.println("AT " + datos.AT);
                    System.out.println("DT " + datos.DT);
                    System.out.println("TMm " + datos.TMm);
                    System.out.println("Event " + datos.Evento);
                    System.out.println("Global.AT < Global.DT " + (datos.AT < datos.DT));
                    System.out.println("Global.AT >= Global.DT " + (datos.AT >= datos.DT));
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    
                    entrante = nuevo;
                }else{
                    datos.TMm = datos.DT;
                    VaciarServidor();
                }
            }
            System.out.println("Salio primer while");
            datos.TMd = datos.TMd + 1;
        }
    }
    
    private void Insertar(Estacion estacion, Cliente cliente){
        ArrayList<Servidor> opciones = new ArrayList<>();
        
        for(Servidor servidor: estacion.getServidores()){
            if(servidor.getCliente() == null){
                opciones.add(servidor);
            }
        }
        
        int rand = datos.GetInterval(0, opciones.size()-1);
        System.out.println("Entra a estacion "+ estacion.getIdEstacion()+ "el cliente " + cliente.getNumeroCliente());
        opciones.get(rand).setCliente(cliente);
        cliente.setSalidaEstacion(datos.TMm + cliente.getST());
        System.out.println("Saldra en el TM " + cliente.getSalidaEstacion());
        datos.DT = datos.TMm + cliente.getST();
    }
    
    private void VaciarServidor(){
        Estacion estacionAVaciar = null;
        Servidor servidorAVaciar = null;
        Cliente cliente;
        
        for(Estacion estacion: estaciones){
            for(Servidor servidor: estacion.getServidores()){
                if(servidor.getCliente() != null && servidor.getCliente().getSalidaEstacion() == datos.TMm){
                    estacionAVaciar = estacion;
                    servidorAVaciar = servidor;
                    System.out.println("Encontro servidor a vaciar");
                }
            }
        }
        
        if(servidorAVaciar != null){
            cliente = servidorAVaciar.getCliente();
            servidorAVaciar.setCliente(null);
            
            //registrar datos
            
            if(estacionAVaciar.getCola().size() > 0){
                Cliente primeroEnCola = estacionAVaciar.getCola().get(0);
                estacionAVaciar.getCola().remove(0);
                Insertar(estacionAVaciar, primeroEnCola);
            }else{
                datos.DT = datos.infinito;
                /*int statusCola = revisarColas();
                
                if(statusCola == 0){
                    datos.DT = datos.infinito;
                }else{
                    datos.DT = statusCola;
                }*/
            }
            
            if(estacionAVaciar.getIdEstacion() < datos.EMaxima){
                Insertar(estaciones.get(estacionAVaciar.getIdEstacion()), cliente);
                Simulacion.AnunciarEvento("Salida", cliente, estacionAVaciar, datos);
                Simulacion.AnunciarEvento("Entrada", cliente, estaciones.get(estacionAVaciar.getIdEstacion()), datos);
            }else{
                Simulacion.AnunciarEvento("Salida", cliente, estacionAVaciar, datos);
            }
            System.out.println("Sale de la estacion "+ estacionAVaciar.getIdEstacion()+ "el cliente" + cliente.getNumeroCliente());
        }else{
            System.out.println("No encontro servidor a vaciar");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
                    
    }
    
    public int revisarColas(){
        int status = datos.infinito;
        
        for(Estacion estacion: estaciones){
            if(estacion.getCola().size() > 0){
                for(Servidor servidor: estacion.getServidores()){
                    if(servidor.getCliente() != null && status > servidor.getCliente().getSalidaEstacion()){
                        status = servidor.getCliente().getSalidaEstacion();
                    }
                }
            }
        }
        
        if(status != datos.infinito)
            return status;
        else
            return 0;
    }
    
}
