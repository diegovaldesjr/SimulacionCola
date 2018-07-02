/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.Simulacion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class SimulacionCola {
    private ArrayList<Estacion> estaciones;
    private Global datos;

    public SimulacionCola(Simulacion windows,int MaxTMd, int MaxTMm, int EMaxima,
            int SMaxima) {
        //Clase que tendra las variables de estado
        datos = new Global(MaxTMd, MaxTMm, EMaxima, SMaxima);
        
        //Inicializar las estaciones
        estaciones = new ArrayList<>();
        for(int i=0; i< EMaxima; i++)
            estaciones.add(new Estacion(windows, SMaxima));
        
        //Empieza la simulacion
        Start();
    }
    
    public Global getDatos() {
        return datos;
    }
    
    public void Start(){
        System.out.println("Inicia simulacion");

        //Inicializan las variables de estado
        datos.TMm = datos.Cero;
        datos.TMd = datos.Cero;

        datos.AT = datos.Cero;
        datos.DT = datos.infinito;

        Cliente entrante;
        Cliente nuevo;
        
        //Si el Numero de dias es menor al ingresado por el cliente
        while(datos.TMd < datos.MaxTMd){
            //Primer cliente del dia
            entrante = new Cliente(datos.Cero, Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
            
            //Si el tiempo actual en minutos es menor al tiempo declarado
            while(datos.TMm < datos.MaxTMm){
                
                if(datos.AT < datos.DT){
                    //Anuncia al cliente a entrar en el sistema
                    Simulacion.AnunciarCliente(entrante);
                    
                    //Actualiza TM
                    datos.TMm = datos.AT;
                    
                    System.out.println("Entrada" + entrante.getIT());
                    System.out.println("Salida" + entrante.getST());
                    
                    //Si algun servidor esta desocupado en la primera estacion
                    if(estaciones.get(0).ServidorVacio() == 1){
                        //Insertar nuevo cliente en algun servidor desocupado
                        Insertar(estaciones.get(0), entrante);
                    }else{
                        //Añadir al cliente en la cola
                        System.out.println("Añadir cliente a Cola");
                        estaciones.get(0).getCola().add(entrante);
                    }
                    
                    //Se genera el proximo cliente a llegar en la siguiente iteracion
                    nuevo = new Cliente(Probabilidad.TiempoEntreLlegadas(datos.GetInterval()), Probabilidad.TiempoPrimeraEstacion(datos.GetInterval()));
                    
                    //Actualizo AT
                    datos.AT = datos.TMm + nuevo.getIT();
                    
                    //Anuncio evento de entrada
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
                    //Actualizo TM
                    datos.TMm = datos.DT;
                    
                    //Llamo funcion que saca a cliente del servidor que dejara de ser atendido
                    VaciarServidor();
                }
            }
            System.out.println("Salio primer while");
            calcular();
            //Actualizo TM de dias
            datos.TMd = datos.TMd + 1;
        }
    }
    
    //Inserta un cliente en un servidor desocupado en una estacion dada
    private void Insertar(Estacion estacion, Cliente cliente){
        ArrayList<Servidor> opciones = new ArrayList<>();
        
        //Busca servidores disponibles
        for(Servidor servidor: estacion.getServidores()){
            if(servidor.getCliente() == null){
                opciones.add(servidor);
            }
        }
        
        //Genera un numero random que sera el indice correspondiente a una estacion desocupada
        int rand = datos.GetInterval(0, opciones.size()-1);
        System.out.println("Entra a estacion "+ estacion.getIdEstacion()+ "el cliente " + cliente.getNumeroCliente());
        
        //El cliente pasa a ser atendido
        opciones.get(rand).setCliente(cliente);
        
        //Se genera el tiempo en que va a dejar de ser atendido
        cliente.setSalidaEstacion(datos.TMm + cliente.getST());
        System.out.println("Saldra en el TM " + cliente.getSalidaEstacion());
        
        //Actualizo DT
        datos.DT = datos.TMm + cliente.getST();
    }
    
    //Ejecuta una salida de un cliente de una estacion y si hay una siguiente
    //Lo inserta en ella
    private void VaciarServidor(){
        Estacion estacionAVaciar = null;
        Servidor servidorAVaciar = null;
        Cliente cliente;
        
        //Se busca por las estaciones el servidor cuyo cliente tenga su tiempo de salida
        //Igual al tiempo actual
        for(Estacion estacion: estaciones){
            for(Servidor servidor: estacion.getServidores()){
                if(servidor.getCliente() != null && servidor.getCliente().getSalidaEstacion() == datos.TMm){
                    estacionAVaciar = estacion;
                    servidorAVaciar = servidor;
                    System.out.println("Encontro servidor a vaciar");
                }
            }
        }
        
        //Si encontro el servidor a desocupar
        if(servidorAVaciar != null){
            //Se saca al cliente del servidor
            cliente = servidorAVaciar.getCliente();
            servidorAVaciar.setCliente(null);
            
            //Aqui faltan registrar datos para las estadisticas
            
            //Se verfica si la cola tiene personas
            if(estacionAVaciar.getCola().size() > 0){
                //Sacar el primero en la cola y colocarlo en servidor
                Cliente primeroEnCola = estacionAVaciar.getCola().get(0);
                estacionAVaciar.getCola().remove(0);
                Insertar(estacionAVaciar, primeroEnCola);
            }else{
                //Actualizar DT a infito para que llegue otro cliente en la siguiente iteracion
                datos.DT = datos.infinito;
                /*int statusCola = revisarColas();
                
                if(statusCola == 0){
                    datos.DT = datos.infinito;
                }else{
                    datos.DT = statusCola;
                }*/
            }
            
            //Si existe una estacion siguiente
            if(estacionAVaciar.getIdEstacion() < datos.EMaxima){
                //Inserta y anuncia al cliente que paso a la siguiente estacion
                Insertar(estaciones.get(estacionAVaciar.getIdEstacion()), cliente);
                Simulacion.AnunciarEvento("Salida", cliente, estacionAVaciar, datos);
                Simulacion.AnunciarEvento("Entrada", cliente, estaciones.get(estacionAVaciar.getIdEstacion()), datos);
            }else{
                //Sino solo se anuncia su salida del servidor
                Simulacion.AnunciarEvento("Salida", cliente, estacionAVaciar, datos);
            }
            System.out.println("Sale de la estacion "+ estacionAVaciar.getIdEstacion()+ "el cliente" + cliente.getNumeroCliente());
        }else{
            System.out.println("No encontro servidor a vaciar");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
                    
    }
    
    //Esta no se esta utilizando
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
    
    private void calcular() {
        DefaultTableModel modelo = Simulacion.getModelo();
        DefaultTableModel clienteSim = Simulacion.getModelCliente();
        int estacion = 1;
        
        ArrayList<Integer>[] group = new ArrayList[datos.EMaxima];
        for (int i = 0 ; i<datos.EMaxima; i++) {
            group[i]=new ArrayList<Integer>();
        }
        
        for(int cliente = 0; cliente<Cliente.getCuentaCliente(); cliente++){
            int count = 0;
            for (Estacion array : estaciones) {
                int entrada = 0;
                int salida = 0;

                for(int ciclo = 1; ciclo<modelo.getRowCount(); ciclo++){
                    
                    if( buscarEntrada(modelo,ciclo,array.getIdEstacion(),cliente)!=0){
                        entrada = buscarEntrada(modelo,ciclo,array.getIdEstacion(),cliente);
                        break;
                    }
                }
                for(int ciclo = 0; ciclo<modelo.getRowCount(); ciclo++){
                    if(buscarSalida(modelo,ciclo,array.getIdEstacion(),cliente)!=0){
                        salida = buscarSalida(modelo,ciclo,array.getIdEstacion(),cliente);
                        break;
                    }
                }
                if(entrada<salida){
                    group[array.getIdEstacion()-1].add(salida-entrada);
                }
            }
            

        }
        int resultado = 0;
        for(ArrayList<Integer> lugar: group){
            for(int result: lugar){
                resultado+=result;
                System.out.println("resualt "+result);
                System.out.println("Resultado "+resultado);
            }
        }

        int promediador = 0;
        for(ArrayList<Integer> lugar: group){
            promediador+=lugar.size();
            System.out.println("Promediador "+promediador);
        }
        
        try{
            
            float W = resultado / promediador;
            float L = clienteSim.getRowCount();
            System.out.println(+ resultado+" / " + promediador + " = " + W);
            System.out.println("cantidad de clientes " + clienteSim.getRowCount());
            Simulacion.setJLW(String.valueOf(W));
            Simulacion.setJLL(String.valueOf(L));
            porcentajeDeTiempo(group,resultado);
            
        }catch(Exception e){
            
            Simulacion.setJLW("X");
            Simulacion.setJLL("X");
            
        }
        
    }
    
    private void porcentajeDeTiempo(ArrayList<Integer>[] group,float w){
        
        int count = 0;
        Simulacion.setEstaciones(String.valueOf(w)+" T|Total");
        
        for(ArrayList<Integer> parte : group){
            
            int cuenta = 0;
            count++;
            
            for(int result: parte){
                cuenta+=result;
            }
            
            String rest = String.format("%.2f",(cuenta/w)*100)+"%";
            
            switch(count){
                case 1:Simulacion.setEstacion1(rest);
                    break;
                case 2:Simulacion.setEstacion2(rest);
                    break;
                case 3:Simulacion.setEstacion3(rest);
                    break;
                case 4:Simulacion.setEstacion4(rest);
                    break;   
            }
        }  
    }
    
    private int buscarEntrada(DefaultTableModel modelo,int posicion,int estacion, int cliente){
        if(modelo.getValueAt(posicion, 1).toString()=="Entrada" 
                && Integer.parseInt(modelo.getValueAt(posicion, 9).toString()) == estacion
                && Integer.parseInt(modelo.getValueAt(posicion, 2).toString()) == cliente){
            return Integer.parseInt(modelo.getValueAt(posicion, 4).toString());
        }
        return 0;
    }
    private int buscarSalida(DefaultTableModel modelo,int posicion,int estacion, int cliente){
        if(modelo.getValueAt(posicion, 1).toString()=="Salida" 
                && Integer.parseInt(modelo.getValueAt(posicion, 9).toString()) == estacion
                && Integer.parseInt(modelo.getValueAt(posicion, 2).toString()) == cliente){
            return Integer.parseInt(modelo.getValueAt(posicion, 4).toString());
        }
        return 0;
    }
    
}
