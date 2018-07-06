/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Diego Valdes
 */
public class Probabilidad {
    public static int TiempoEntreLlegadas(int random){
        if(random<=50) return 1;
        if(random<=70) return 2;
        if(random<=85) return 3;
        if(random<=90) return 4;
        if(random<=100) return 5;
        return 0;
    }
    public static int TiempoPrimeraEstacion(int random){
        if(random<=50) return 1;
        if(random<=90) return 2;
        if(random<=100) return 3;
        return 0;
    }

    public static int TiempoSegundaEstacion(int random){
        if(random<=25) return 10;
        if(random<=50) return 12;
        if(random<=75) return 14;
        if(random<=100) return 18;
        return 0;
    }
    public static int TiempoTerceraEstacion(int random){
        if(random<=35) return 2;
        if(random<=70) return 4;
        if(random<=85) return 6;
        if(random<=100) return 8;
        return 0;
    }

    public static int TiempoCuartaEstacion(int random){
        if(random<=45) return 1;
        if(random<=75) return 3;
        if(random<=90) return 5;
        if(random<=100) return 7;
        return 0;
    }
}
