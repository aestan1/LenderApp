package com.example.estan.lenderapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Simulador extends AppCompatActivity {
    private Resources resources;
    private EditText valor;
    private EditText porcentaje;
    private EditText meses;
    private Spinner modo;
    private String mod[];
    private TextView cuota;
    private TextView nCuota;
    private TextView total;
    private Intent i;
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);
        resources = this.getResources();

        valor = (EditText)findViewById(R.id.txtvalor);
        porcentaje = (EditText)findViewById(R.id.txtPorcentaje);
        meses = (EditText)findViewById(R.id.txtMeses);
        modo = (Spinner)findViewById(R.id.cmbModo);
        mod = resources.getStringArray(R.array.modo);
        cuota = (TextView)findViewById(R.id.txtCuota);
        nCuota = (TextView)findViewById(R.id.txtCantCuot);
        total = (TextView)findViewById(R.id.txtTotal);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mod);
        modo.setAdapter(adapter1);

    }

    public boolean validar(){
        int mo;
        mo= modo.getSelectedItemPosition();
        if (valor.getText().toString().isEmpty()){
            valor.setError(resources.getString(R.string.error1));
            return  false;
        }
        else if (porcentaje.getText().toString().isEmpty()){
            porcentaje.setError(resources.getString(R.string.error1));
            return  false;
        }
        else if (meses.getText().toString().isEmpty()){
            meses.setError(resources.getString(R.string.error1));
            return  false;
        }

        if(mo==0) {
            Toast.makeText(this, resources.getString(R.string.error3), Toast.LENGTH_SHORT ).show();
            return false;
        }

        //valores mayores que cero
        if(Integer.parseInt(valor.getText().toString())<=0){
            valor.setError(resources.getString(R.string.error2));
            return false;
        }
        else if(Integer.parseInt(porcentaje.getText().toString())<=0){
            porcentaje.setError(resources.getString(R.string.error2));
            return false;
        }
        else if(Integer.parseInt(meses.getText().toString())<=0){
            meses.setError(resources.getString(R.string.error2));
            return false;
        }
        return true;
    }

    public void calcular (View v){
        double  valCuot=0, tot=0;
        int aux, val, porc, me, opc , cuotas=0;
        cuota.setText("");
        nCuota.setText("");
        if(validar()){
            opc= modo.getSelectedItemPosition();
            val= Integer.parseInt(valor.getText().toString());
            porc=Integer.parseInt(porcentaje.getText().toString());
            me=Integer.parseInt(meses.getText().toString());

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

            cuota.setText("$: " + String.format("%.2f", valCuot));
            nCuota.setText(""+ cuotas*me);
            total.setText("$: "+String.format("%.2f", tot));




        }
    }

    public void limpiar (View v){
    valor.setText("");
        porcentaje.setText("");
        meses.setText("");
        modo.setSelection(0);
        cuota.setText("");
        nCuota.setText("");
        total.setText("");

    }
}
