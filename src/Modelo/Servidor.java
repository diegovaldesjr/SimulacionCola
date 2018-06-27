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

    public Cliente getCliente() {
        return cliente;
    }

    public Servidor() {
        this.cliente = null;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
