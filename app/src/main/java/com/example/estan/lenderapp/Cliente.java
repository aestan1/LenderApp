package com.example.estan.lenderapp;

/**
 * Created by Estan on 11/11/2017.
 */

public class Cliente {

    private String id;
    private String cedula;
    private String nombre;
    private String apellido;
    private int sexo;
    private String direccion;
    private String celular;
    private Prestamo prestamo;

    public Cliente(String cedula, String nombre, String apellido, int sexo, String direccion, String celular, Prestamo prestamo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo=sexo;
        this.direccion = direccion;
        this.celular = celular;
        this.prestamo = prestamo;
    }

    public Cliente(String id, String cedula, String nombre, String apellido, int sexo, String direccion, String celular, Prestamo prestamo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo=sexo;
        this.direccion = direccion;
        this.celular = celular;
        this.prestamo = prestamo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void guardar(){
        Datos.guardarCliente(this);
    }
}
