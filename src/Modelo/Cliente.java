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

    private int NumeroCliente;    
    
    private int IT;
    private int ST;

    static{
        CuentaCliente = 1;
    }

    public Cliente(int IT, int ST) {
        this.IT = IT;
        this.ST = ST;

        NumeroCliente = CuentaCliente++;
        System.out.println("Cliente numero " + NumeroCliente + " " + IT + " " + ST);
    }

    public static int getCuentaCliente() {
        return CuentaCliente;
    }

    public static void setCuentaCliente(int CuentaCliente) {
        Cliente.CuentaCliente = CuentaCliente;
    }

    public int getNumeroCliente() {
        return NumeroCliente;
    }

    public void setNumeroCliente(int NumeroCliente) {
        this.NumeroCliente = NumeroCliente;
    }

    public int getIT() {
        return IT;
    }

    public void setIT(int IT) {
        this.IT = IT;
    }

    public int getST() {
        return ST;
    }

    public void setST(int ST) {
        this.ST = ST;
    }

    

}
