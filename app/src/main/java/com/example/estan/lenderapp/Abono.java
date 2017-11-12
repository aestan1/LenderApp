package com.example.estan.lenderapp;

import java.util.Date;

/**
 * Created by Estan on 11/11/2017.
 */

public class Abono {
    private String id;
    private int valor;
    private String fecha;

    public Abono(){

    }

    public Abono(int valor, String fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

    public Abono(String id, int valor, String fecha) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
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
}


