package com.example.estan.lenderapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AgregarPrestamo extends AppCompatActivity {
private EditText txtValor;
private EditText txtNcuot;
private EditText txtPorcentaje;
private EditText txtFechaAct;
private Intent i;
private Bundle b;
private StorageReference storageReference;
private Uri uri;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_agregar_prestamo);

    txtValor = (EditText)findViewById(R.id.txtValor);
    txtPorcentaje = (EditText)findViewById(R.id.txtPorcentaje);
    txtNcuot = (EditText)findViewById(R.id.txtCuotas);
    txtFechaAct = (EditText)findViewById(R.id.txtFechaPres);

    Calendar Cal= Calendar.getInstance();
    String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR)+" "+Cal.get(Cal.HOUR_OF_DAY)+":"+Cal.get(Cal.MINUTE)+":"+Cal.get(Cal.SECOND);

   txtFechaAct.setText(fec);
    storageReference = FirebaseStorage.getInstance().getReference();


    i = getIntent();
    b = i.getBundleExtra("datos");

}

public void agregarPrestamo(View v){
    int valor = Integer.parseInt(txtValor.getText().toString());
    int porcentaje = Integer.parseInt(txtPorcentaje.getText().toString());
    int cuotas = Integer.parseInt(txtNcuot.getText().toString());
    String fecha = txtFechaAct.getText().toString();
    ArrayList<Abono> abonos= new ArrayList<>();
    Prestamo p = new Prestamo(b.getString("id"),valor,valor,cuotas, cuotas, fecha, fecha, abonos);

            p.guardar();
            Snackbar.make(v, R.string.mensaje_cliente_guardado,Snackbar.LENGTH_SHORT).setAction("action",null).show();




}


public Prestamo nuevop(){
    int aux = 0;
    int valor = Integer.parseInt(txtValor.getText().toString());
    int porcentaje = Integer.parseInt(txtPorcentaje.getText().toString());
    int  cuotas =  Integer.parseInt(txtNcuot.getText().toString());
    String fecha = txtFechaAct.getText().toString();
    int deuda = valor+(valor*porcentaje/100);
    ArrayList<Abono> abonos= new ArrayList<>();

    Prestamo p = new Prestamo(b.getString("id"),valor,deuda,cuotas,cuotas, fecha, fecha, abonos );
    Cliente c = new Cliente(b.getString("id"), b.getString("cedula"), b.getString("nombre"), b.getString("apellido"),Integer.parseInt(b.getString("sexo")),b.getString("direccion"),b.getString("celular"), p);

       return p;

    }

    public void agregarPrestamoNuevo (View v){
    Prestamo p = nuevop();
        Cliente c = new Cliente(b.getString("id"), b.getString("cedula"), b.getString("nombre"), b.getString("apellido"),Integer.parseInt(b.getString("sexo")),b.getString("direccion"),b.getString("celular"), p);

        c.modificar();

        Snackbar.make(v, R.string.mensaje_prestamo_agregado_exitosamente,Snackbar.LENGTH_SHORT)
                .setAction("action",null).show();
    }


public void limpiar(View v) {
    txtNcuot.setText("");
    txtPorcentaje.setText("");
    txtValor.setText("");
}








}

