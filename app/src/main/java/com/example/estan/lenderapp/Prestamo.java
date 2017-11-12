package com.example.estan.lenderapp;

/**
 * Created by Estan on 11/11/2017.
 */

public class Prestamo {
    private String id;
    private int valor;
    private int deudaActual;
    private String fechaI;
    private String fechaF;
    private Abono abono;

    public Prestamo(){

    }


    public Prestamo(String id, int valor, int deudaActual, String fechaI, String fechaF, Abono abono) {
        this.id = id;
        this.valor = valor;
        this.deudaActual = deudaActual;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.abono = abono;
    }

    public Prestamo(int valor, int deudaActual, String fechaI, String fechaF, Abono abono) {
        this.valor = valor;
        this.deudaActual = deudaActual;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.abono = abono;
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

    public int getDeudaActual() {
        return deudaActual;
    }

    public void setDeudaActual(int deudaActual) {
        this.deudaActual = deudaActual;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }
}
