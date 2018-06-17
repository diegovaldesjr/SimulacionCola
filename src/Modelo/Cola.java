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
public class Cola {
    private Cliente Entrante;
    private ArrayList<Estacion> Estaciones;
    private Global datos;
    

    public Cola(Simulacion windows,int MaxTMd, int MaxTMm, int EMinima, int EMaxima,
            int SMinima, int SMaxima) {
        datos = new Global(MaxTMd, MaxTMm, EMinima, EMaxima,
            SMinima, SMaxima);
        Estaciones = new ArrayList<>();
        for(int i=0; i< datos.NumeroEstaciones; i++)
            Estaciones.add(new Estacion(windows));
        
        Start();
    }

    public Global getDatos() {
        return datos;
    }
    
    public void Start(){
        
        System.out.println("Simulacion Run:Inicio");

        datos.TMm = datos.Cero;
        datos.TMd = datos.Cero;

        datos.AT = datos.Cero;
        datos.DT = datos.infinito;

        Cliente nuevo;

        while (datos.TMd < datos.MaxTMd) {
            Entrante = new Cliente(datos.Cero, Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
            while (datos.TMm < datos.MaxTMm) {

                if(datos.AT<datos.DT){

                    datos.TMm = datos.AT;
                    Simulacion.AnunciarCliente(Entrante);

                    System.out.println("Entrada " + Entrante.getEntrada());
                    System.out.println("Salida " + Entrante.getSalida());

                    nuevo =  new Cliente(Probabilidad.TiempoEntreLlegadas(datos.GetInterval()), Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
                    datos.AT = datos.TMm + nuevo.getEntrada();
                    if (Estaciones.get(0).ServidoresVacio() == Global.Cero) {
                        System.out.println("Servidor desocupado");
                        datos.DT = datos.TMm + Entrante.getSalida();

                        Incrustar(Estaciones.get(0), Entrante);
                    }else{
                        System.out.println("Añadir cliente a Cola");
                        Estaciones.get(0).getCola().add(Entrante);
                    }
                    Simulacion.AnunciarEvento("Entrada",Entrante, Estaciones.get(0), datos);
                    Entrante = nuevo;

                }else{
                    datos.TMm = datos.DT;

                    for(int i=0; i<Estaciones.size(); i++){
                        ArrayList<Servidor> servidores = Estaciones.get(i).getServidores();

                        for (Servidor servidor: servidores) {
                            //Arreglar condicion a veces cae en un loop
                            if(servidor.getCliente()!=null && servidor.getCliente().getSalidaEstacion() == datos.DT){
                                System.out.println("Aqui");
                                if(Estaciones.get(i).getCola().size() > 0){
                                    datos.DT = datos.TMm + servidor.getCliente().getSalida();
                                }else{
                                    datos.DT = Global.infinito;
                                }

                                Cliente saliente = servidor.getCliente();
                                servidor.setCliente(null);
                                Simulacion.AnunciarEvento("Salida",saliente, Estaciones.get(i), datos);
                                
                                //Si tengo una siguiente estacion
                                if(i+1<datos.NumeroEstaciones && Estaciones.get(i+1) != null){
                                    switch(Estaciones.get(i+1).getIdEstacion()){
                                        case 2: saliente.setSalida(Probabilidad.TiempoSegundaEstacion(datos.GetInterval()));
                                                break;
                                        case 3: saliente.setSalida(Probabilidad.TiempoTerceraEstacion(datos.GetInterval()));
                                                break;
                                        case 4: saliente.setSalida(Probabilidad.TiempoCuartaEstacion(datos.GetInterval()));
                                                break;
                                    }
                                    if(Estaciones.get(i+1).CountServidoresOcupados() < Estaciones.get(i+1).getMaxServer()){
                                        Incrustar(Estaciones.get(i+1), saliente);
                                    }else{
                                        Estaciones.get(i+1).getCola().add(saliente);
                                    }
                                }else{
                                    datos.Salida.add(saliente);
                                }

                            }
                        }
                    }
                }
                
                System.out.println("Entrada sig " + Entrante.getEntrada());
                System.out.println("Salida sig " + Entrante.getSalida());
                System.out.println("AT " + datos.AT);
                System.out.println("DT " + datos.DT);
                System.out.println("TMm " + datos.TMm);
                System.out.println("TMd " + datos.TMd);
                System.out.println("Event " + datos.Evento);
                System.out.println("Global.AT < Global.DT " + (datos.AT < datos.DT));
                System.out.println("Global.AT >= Global.DT " + (datos.AT >= datos.DT));
                System.out.println("----------------------------------------------------------------------------------------------------------");

            }
            System.out.println("Salio primer while");
            datos.TMd = datos.TMd + 1;
        }

    }
    
    private void Incrustar(Estacion estacion, Cliente cliente){
        ArrayList<Servidor> opciones = new ArrayList<>();
        for (Servidor servidor: estacion.getServidores()) {
            if(servidor.getCliente() == null) {
                opciones.add(servidor);
            }
        }
        int rand = datos.GetInterval(0, opciones.size()-1);
        opciones.get(rand).setCliente(cliente);
        cliente.setSalidaEstacion( datos.TMm + cliente.getSalida() );
        //Simulacion.AnunciarEvento("Entrada",Entrante, estacion, datos);
    }


}
