/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Diego Valdes
 */
public class Global {
    public static final int infinito = 999999999;
    public static final int MaximosMinutos = 1440;
    public static final int Cero = 0;
    public int AT = 0;
    public int DT = 0;
    public int EMaxima = 0;
    public int EMinima = 0;
    public int SMaxima = 0;
    public int SMinima = 0;
    public int TMd = 0;//TM normal pero referente a los dias
    public int TMm = 0;//TM normal pero referente a los minutos
    public int MaxTMd = 0;
    public int MaxTMm = 0;
    
    //private static Cliente Entrada;
    public ArrayList<Cliente> Salida = new ArrayList<Cliente>();
    public int Evento = 0;
    /*
    * las dos siguentes funciones evaluan si la simulacion es continua
    * */

    public Global(int MaxTMd, int MaxTMm, int EMaxima, int SMaxima) {
        this.MaxTMd = MaxTMd;
        this.MaxTMm = MaxTMm;
        this.EMinima = 1;
        this.EMaxima = EMaxima;
        this.SMinima = 1;
        this.SMaxima = SMaxima;
    }
    
    public int CalcularMaxTMd(){
        if(MaxTMm == MaximosMinutos){
            return 0;
        }else{
            return MaxTMd;
        }
    }
    public int CalcularMaxTMm(){
        if(MaxTMm == MaximosMinutos){
            return TMm*TMd;
        }else{
            return MaxTMm;
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

   /* public static Cliente getEntrada() { return Entrada; }
    public static void setEntrada(Cliente entrada) { Entrada = entrada; }*/

    public  ArrayList<Cliente> getSalida() { return this.Salida; }
    public void addSalida(Cliente salida) { this.Salida.add(salida); }

    
}
