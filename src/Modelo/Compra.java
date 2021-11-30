/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @author Pía Trujillo / José Ignacio Gutiérrez
 */
public class Compra {
    
    private String alias;
    private int cantidadEntrada;

    public Compra() {
    }

    public Compra(String alias, int cantidadEntrada) {
        this.alias = alias;
        this.cantidadEntrada = cantidadEntrada;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }
    
    
    
    
}
