package com.example.estan.lenderapp;

import android.widget.TextView;

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
}
