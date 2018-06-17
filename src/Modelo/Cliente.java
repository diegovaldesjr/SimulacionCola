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
public class Cliente {
    private static int CuentaCliente;
    private int Entrada;
    private int Salida;
    private int NumeroCliente;
    private int EntradaEstacion;
    private int SalidaEstacion;

    static{
        CuentaCliente = 0;
    }

    public Cliente(int AT, int DT) {
        this.Entrada = AT;
        this.Salida = DT;
        NumeroCliente = (++CuentaCliente);
    }

    public int getEntrada() {
        return Entrada;
    }

    public int getSalida() {
        return Salida;
    }

    public int getNumeroCliente() {
        return NumeroCliente;
    }

    public static int getCuentaCliente() {
        return CuentaCliente;
    }

    public void setSalida(int salida) {
        Salida = salida;
    }

    public void setEntrada(int entrada) { Entrada = entrada; }

    public static void setCuentaCliente(int cuentaCliente) {
        CuentaCliente = cuentaCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        NumeroCliente = numeroCliente;
    }

    public int getEntradaEstacion() {
        return EntradaEstacion;
    }

    public void setEntradaEstacion(int entradaEstacion) {
        EntradaEstacion = entradaEstacion;
    }

    public int getSalidaEstacion() {
        return SalidaEstacion;
    }

    public void setSalidaEstacion(int salidaEstacion) {
        SalidaEstacion = salidaEstacion;
    }

}
