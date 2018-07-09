/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.Simulacion;
import static Interfaces.Simulacion.Cero;
import Interfaces.VisorEstacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Valdes
 */
public class Estacion {
    private ArrayList<Servidor> Servidores;
    private ArrayList<Cliente> Cola;
    
    private int AT;
    private int DT;
    
    private final int MinServer = 1;
    private int MaxServer;
    private int NumeroEstacion;
    
    private static Simulacion s;
    private VisorEstacion visor;
    
    Cliente entrante;
    Cliente nuevo;
    
    private int nClientes;
    private int nClientesCola;
    
    static{s = Simulacion.simulacion;}
    
    public Estacion( VisorEstacion visor, int NumeroEstacion) {
       this.NumeroEstacion = NumeroEstacion;
        
        int prueba= Integer.parseInt(JOptionPane.showInputDialog("Por Favor, ingrese la cantidad de servidores para la estacion "+NumeroEstacion));
        //JOptionPane.showMessageDialog(null,"tu nombre es: "+prueba);
        this.MaxServer =prueba;
        AT = 0;
        DT = Simulacion.Infinito;
        this.visor = visor;
        //Cola de la estacion
        Cola = new ArrayList<Cliente>();
        
        //Servidores de la estacion
        Servidores = new ArrayList<Servidor>();
        this.MaxServer = MaxServer;
        
        for (int i = 0; i < MaxServer; i++) {
            Servidores.add(new Servidor());
        }
        
        //Numero de estacion
        
        
        nClientes = 0;
        nClientesCola = 0;
        if(NumeroEstacion == 1)
            entrante = new Cliente(Cero, Probabilidad.TiempoPrimeraEstacion(s.GetInterval()));;
    }
    
    public void simulacionCola(){
        //Solo se generan cliente para entrar en la primera estacion
        if(AT < DT && NumeroEstacion == 1 && s.getTMm() < s.getMaxTMm()){
            //Anuncia al cliente a entrar en el sistema
            visor.AnunciarCliente(entrante);
            
            //Actualiza TM
            s.setTMm(AT);

            Insertar(entrante, false);
            
            entrante = nuevo;
        }else if(ServidoresVacios() == 0){
            //Actualizo TM
            s.setTMm(DT);

            //Llamo funcion que saca a cliente del servidor que dejara de ser atendido
            VaciarServidor();
        }     
    }

    //Retorna 1 si todos los servidores estan vacios
    //Retorna 0 si algun servidor llega a estar ocupado
    public int ServidoresVacios(){
        for (Servidor servidor: Servidores ) {
            if(servidor.getCliente()!=null){
                return 0;
            }
        }
        return 1;
    }
    
    //Retorna 1 si alguno de los servidores esta vacios
    //Retorna 0 si todos servidores llegan a estar ocupado
    public int ServidorDisponible(){
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
    
    //Inserta un en la estacion, verificar si puede ser atendido o si tendra que
    //Esperar en cola
    public void Insertar(Cliente cliente, boolean clienteEnCola){
        //Registrar que cuenta de clientes que han pasado por el servidor
        nClientes++;
        
        //Si algun servidor esta desocupado en la primera estacion
        if(ServidorDisponible() == 1){
            //Insertar nuevo cliente en algun servidor desocupado
            atenderCliente(cliente);
        }else{
            //Añadir al cliente en la cola
            System.out.println("Añadir cliente a Cola");
            Cola.add(cliente);
            nClientesCola++;
        }
        
        if(NumeroEstacion == 1){
            //Se genera el proximo cliente a llegar en la siguiente iteracion
            nuevo = s.pedirCliente();
        }else{
            //Pedir proximo a entrar
        }
            
        //nuevo tiene que pedir el proximo a salir de la estacion anterior
        
        //Actualizo AT
        System.out.println("################################################"+s.getTMm());
        System.out.println("################################################"+nuevo.getIT());
        
        AT = s.getTMm() + nuevo.getIT();

        //Anuncio evento de entrada
        if(!clienteEnCola)
            visor.AnunciarEvento("Entrada",cliente, this,s);
        
        System.out.println("Entrada "+entrante.getIT());
        System.out.println("Salida "+entrante.getST());
        System.out.println("Entrada sig "+nuevo.getIT());
        System.out.println("Salida sig "+nuevo.getST());
        System.out.println("AT "+AT);
        System.out.println("DT "+DT);
        System.out.println("TM "+s.getTMm());
        System.out.println("Cola "+Cola.size());
        System.out.println("----------------------------------------------------");
    }
    
    //Inserta un cliente en un servidor desocupado en una estacion dada
    private void atenderCliente(Cliente cliente){
        ArrayList<Servidor> opciones = new ArrayList<>();
        
        //Busca servidores disponibles
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() == null){
                opciones.add(servidor);
            }
        }
        
        //Genera un numero random que sera el indice correspondiente a una estacion desocupada
        int rand = s.GetInterval(0, opciones.size()-1);
        System.out.println("Entra a estacion "+ NumeroEstacion+ " el cliente " + cliente.getNumeroCliente());
        
        //El cliente pasa a ser atendido
        opciones.get(rand).setCliente(cliente);
        
        //Se genera el tiempo en que va a dejar de ser atendido
        cliente.setSalidaEstacion(s.getTMm() + cliente.getST());
        System.out.println("Saldra en el TM " + cliente.getSalidaEstacion());
        
        //Actualizo DT
        DT = s.getTMm() + cliente.getST();
    }
    
    //Ejecuta una salida de un cliente de la estacion y si hay una siguiente
    //Lo inserta en ella
    private void VaciarServidor(){
        Servidor servidorAVaciar = null;
        Cliente cliente;
        
        //Se busca por las estaciones el servidor cuyo cliente tenga su tiempo de salida
        //Igual al tiempo actual
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() != null && servidor.getCliente().getSalidaEstacion() == s.getTMm()){
                servidorAVaciar = servidor;
                System.out.println("Encontro servidor a vaciar");
            }
        }
        
        
        //Si encontro el servidor a desocupar
        if(servidorAVaciar != null){
            //Se saca al cliente del servidor
            cliente = servidorAVaciar.getCliente();
            servidorAVaciar.setCliente(null);
            
            //Aqui faltan registrar datos para las estadisticas
            
            //Se verfica si la cola tiene personas
            if(Cola.size() > 0){
                //Sacar el primero en la cola y colocarlo en servidor
                Cliente primeroEnCola = Cola.get(0);
                Cola.remove(0);
                DT = s.getTMm() + cliente.getST();
                Insertar(primeroEnCola, true);
            }else{
                //Actualizar DT a infito para que llegue otro cliente en la siguiente iteracion
                DT = Simulacion.Infinito;
            }
            visor.AnunciarEvento("Salida", cliente, this,s);
            
            //s.AnunciarEvento("Salida", cliente, this);
            s.avanzarCliente(cliente, NumeroEstacion);
            
            
            System.out.println("Sale de la estacion "+ NumeroEstacion + " el cliente" + cliente.getNumeroCliente());
        }else{
            System.out.println("No encontro servidor a vaciar");
        }
        
    }
    public void Calcular() {
        visor.CalcularTodo();
    }
    
    public int servidoresOcupados(){
        int cuenta = 0;
        
        for(Servidor servidor: Servidores){
            if(servidor.getCliente() != null)
                cuenta++;
        }
        
        return cuenta;
    }

    public ArrayList<Cliente> getCola(){
        return Cola;
    }

    public int getNumeroEstacion() {
        return NumeroEstacion;
    }

    public int getAT() {
        return AT;
    }

    public int getDT() {
        return DT;
    }

    public ArrayList<Servidor> getServidores() {
        return Servidores;
    }

    public int getnClientesCola() {
        return nClientesCola;
    }
    
}
