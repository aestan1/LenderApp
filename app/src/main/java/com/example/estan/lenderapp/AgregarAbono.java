package com.example.estan.lenderapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgregarAbono extends AppCompatActivity {
    private EditText txtValor;
    private EditText txtFechaAct;
    private Resources res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_abono);
        res = this.getResources();
        txtValor = (EditText) findViewById(R.id.txtvalor);
        txtFechaAct = (EditText)findViewById(R.id.txtFechaAct);
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(" dd/MM/YY, h:mm a");
        txtFechaAct.setText(format.format(fechaActual.getTime()).toString());

    }





}
