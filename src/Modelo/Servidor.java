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

    
    public Cliente getCliente() {
        return cliente;
    }

    public Servidor() {
        this.cliente = null;
        CountClientes=0;
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
    
    

}
