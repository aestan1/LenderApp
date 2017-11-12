package com.example.estan.lenderapp;

import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Estan on 11/11/2017.
 */

public class Datos {

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private  static String bd = "Clientes";
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void guardarCliente(Cliente c){

        databaseReference.child(bd).child(c.getId()).setValue(c);
    }

    public static ArrayList<Cliente> obtenerClientes(){
        return clientes;
    }


    public static void setClientes(ArrayList<Cliente> cli){
        clientes=cli;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }
    public static void actualizar(Cliente c){
        databaseReference.child(bd).child(c.getId()).setValue(c);
    }

    public static void eliminar (Cliente c){
        databaseReference.child(bd).child(c.getId()).removeValue();
    }


}
