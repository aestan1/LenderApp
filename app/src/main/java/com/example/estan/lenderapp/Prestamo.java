package com.example.estan.lenderapp;

import java.util.ArrayList;

/**
 * Created by Estan on 11/11/2017.
 */

public class Prestamo {
    private String id;
    private int valor;
    private int deudaActual;
    private int cuotas;
    private int cuotasRestantes;
    private String fechaI;
    private String fechaF;
    private ArrayList<Abono> abonos;

    public Prestamo() {

    }

    public Prestamo(String id, int valor, int deudaActual, int cuotas, int cuotasRestantes, String fechaI, String fechaF, ArrayList<Abono> abonos) {
        this.id = id;
        this.valor = valor;
        this.deudaActual = deudaActual;
        this.cuotas = cuotas;
        this.cuotasRestantes = cuotasRestantes;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.abonos = abonos;
    }

    public Prestamo(int valor, int deudaActual, int cuotas, int cuotasRestantes, String fechaI, String fechaF, ArrayList<Abono> abonos) {
        this.valor = valor;
        this.deudaActual = deudaActual;
        this.cuotas = cuotas;
        this.cuotasRestantes = cuotasRestantes;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.abonos = abonos;
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

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getCuotasRestantes() {
        return cuotasRestantes;
    }

    public void setCuotasRestantes(int cuotasRestantes) {
        this.cuotasRestantes = cuotasRestantes;
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

    public ArrayList<Abono> getAbonos() {
        return abonos;
    }

    public void setAbonos(ArrayList<Abono> abonos) {
        this.abonos = abonos;
    }

    public void guardar(){
        Datos.guardarPrestamo(this);
    }

    public void modificar(){Datos.actualizarP(this);}

    //public void eliminar (){Datos.eliminar(this);}*/
}



