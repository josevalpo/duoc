/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Pía Trujillo / José Ignacio Gutiérrez
 */
public class Entrada {
    
    private String titulo;
    private String alias;
    private Date funcion;
    private int cantidadEntrada;
    private int precio;
    private boolean disponible;

    public Entrada() {
    }

    public Entrada(String titulo, String alias, Date funcion, int cantidadEntrada, int precio, boolean disponible) {
        this.titulo = titulo;
        this.alias = alias;
        this.funcion = funcion;
        this.cantidadEntrada = cantidadEntrada;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getFuncion() {
        return funcion;
    }

    public void setFuncion(Date funcion) {
        this.funcion = funcion;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
    
}
