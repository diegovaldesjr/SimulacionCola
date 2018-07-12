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
public class Servidor {
    private Cliente cliente;
    private int CountClientes;
    private int DT;

    public Servidor() {
        this.cliente = null;
        this.CountClientes = 0;
        this.DT = 0;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if(cliente != null){
            CountClientes++;
        }
        this.cliente = cliente;
    }

    public int getCountClientes() {
        return CountClientes;
    }

    public int getDT() {
        return DT;
    }

    public void setDT(int DT) {
        this.DT = DT;
    }


}
