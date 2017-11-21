package com.example.estan.lenderapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        txtFechaAct.setText("hola");

    }

    public void agregarAbono(View v) {
      //  if (validar()) {
            Abono a = new Abono( Integer.parseInt(txtValor.getText().toString()), txtFechaAct.getText().toString(), "agregado");

            a.guardar();
            Snackbar.make(v, res.getString(R.string.mensaje_cliente_guardado), Snackbar.LENGTH_LONG).setAction("Action", null).show();

       // }
    }

    public void limpiar(View v){
        txtValor.setText("");
    }

    public void onBackPressed() {
        finish();
        Intent i = new Intent(AgregarAbono.this, Principal2.class);
        startActivity(i);
    }





}
