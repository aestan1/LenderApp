package com.example.estan.lenderapp;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Estan on 11/11/2017.
 */

public class Metodos {

    public static boolean validar_aux(TextView t, String mensaje) {
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return false;
    }

    public static boolean validarCelular(TextView t, String mensaje) {
        if (t.getText().toString().isEmpty()||t.length()!=10){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return false;
    }

    public static boolean ValidarDeuda(ArrayList<Cliente> clientes){
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getPrestamo().getDeudaActual()==0) return true;
        }
        return false;
    }

    public static Double calcularValorCuotas (int val, int porc, int me, int opc){
        double  valCuot=0, tot=0, cuotas=0;
        int aux;

            if(opc==1){
                cuotas=30;
            }
            else if(opc==2){
                cuotas=4;
            }
            else if(opc==3){
                cuotas = 2;
            }
            else if (opc==4){
                cuotas = 1;
            }


            aux= (val*porc)/100;
            porc=aux*me;
            valCuot=(val+porc)/(cuotas*me);
            tot=val+porc;


            return valCuot;
    }

    public static Double calcularTotal (int val, int porc, int me, int opc){
        double  valCuot=0, tot=0, cuotas=0;
        int aux;

        if(opc==1){
            cuotas=30;
        }
        else if(opc==2){
            cuotas=4;
        }
        else if(opc==3){
            cuotas = 2;
        }
        else if (opc==4){
            cuotas = 1;
        }


        aux= (val*porc)/100;
        porc=aux*me;
        valCuot=(val+porc)/(cuotas*me);
        tot=val+porc;


        return tot;
    }

    public static int calcularCuotas (int opc, int meses){
        double  valCuot=0, tot=0;
        int aux , cuotas=0;

        if(opc==1){
            cuotas=30;
        }
        else if(opc==2){
            cuotas=4;
        }
        else if(opc==3){
            cuotas = 2;
        }
        else if (opc==4){
            cuotas = 1;
        }
        cuotas=cuotas*meses;
        return cuotas;
    }





}
