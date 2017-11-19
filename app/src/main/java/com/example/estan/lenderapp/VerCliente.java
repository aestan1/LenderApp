package com.example.estan.lenderapp;

import android.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class VerCliente extends AppCompatActivity {
    private ImageView foto;
    private TextView lblNombre;
    private TextView lblApellido;
    private EditText txtDireccion;
    private EditText txtCelular;
    private EditText txtCedula;
    private EditText txtDeuda;
    private EditText txtRest;
    private Intent i;
    private Bundle b;
    private StorageReference storageReference;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cliente);
        String nombre;
        String sexo;
        foto = (ImageView) findViewById(R.id.fotoModificar);
        txtCedula = (EditText) findViewById(R.id.txtCedulaVer);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        txtCelular = (EditText) findViewById(R.id.txtTelVer);
        txtDeuda = (EditText) findViewById(R.id.txtDeudaVer);
        txtDireccion = (EditText) findViewById(R.id.txtDireccionVer);
        txtRest=(EditText)findViewById(R.id.txtCuotasVer);


        i = getIntent();
        b = i.getBundleExtra("datos");
        nombre = ""+b.getString("nombre")+" "+b.getString("apellido");
        sexo = b.getString("sexo");
        lblNombre.setText(nombre);
        colocarFoto(sexo);
        txtCedula.setText(b.getString("cedula"));
        txtCelular.setText(b.getString("celular"));
        txtDireccion.setText(b.getString("direccion"));
        txtDeuda.setText(b.getString("deudaActual"));
        txtRest.setText(b.getString("cuotasRestantes"));



    }

    public void llamar(View v) {
        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txtCelular.getText().toString())));
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void onBackPressed(){
        finish();
        Intent i = new Intent(VerCliente.this,Principal.class);
        startActivity(i);
    }

    public void colocarFoto(String sexo){
        if(sexo.equalsIgnoreCase("1")){
            foto.setImageResource(R.drawable.boy2client128);
        }
        else if(sexo.equalsIgnoreCase("2")){
            foto.setImageResource(R.drawable.girl2client128);
        }
    }

    public void agregarP(View v){
        setContentView(R.layout.activity_agregar_prestamo);
    }





}
