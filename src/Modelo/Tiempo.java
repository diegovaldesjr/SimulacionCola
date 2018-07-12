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
public class Tiempo {
    
    int Tiempo;
    float Probabilidad;

    public Tiempo(int Tiempo, float Probabilidad) {
        this.Tiempo = Tiempo;
        this.Probabilidad = Probabilidad;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public float getProbabilidad() {
        return Probabilidad;
    }

    public void setProbabilidad(float Probabilidad) {
        this.Probabilidad = Probabilidad;
    }
    
    
    
}
