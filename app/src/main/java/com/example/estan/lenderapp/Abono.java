package com.example.estan.lenderapp;

import java.util.Date;

/**
 * Created by Estan on 11/11/2017.
 */

public class Abono {
    private String id;
    private int valor;
    private String fecha;
    private String estado;

    public Abono(){

    }

    public Abono(int valor, String fecha, String estado) {
        this.valor = valor;
        this.fecha = fecha;
        this.estado=estado;
    }

    public Abono(String id, int valor, String fecha, String estado) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.estado=estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void guardar(){
        Datos.guardarAbono(this);
    }
}


