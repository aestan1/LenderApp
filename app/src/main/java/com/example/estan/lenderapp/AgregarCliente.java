package com.example.estan.lenderapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class AgregarCliente extends AppCompatActivity {



        private EditText txtCedula;
        private EditText txtNombre;
        private EditText txtApellido;
        private EditText txtDireccion;
        private EditText txtCelular;
        private Spinner cmbSexo;
        private ArrayList<String> adapter;
        private String op;
        private String sex[];
        private Resources res;
        private Uri uri;
        private ImageView foto;
        private StorageReference storageReference;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_agregar_cliente);
            res = this.getResources();
            txtCedula = (EditText) findViewById(R.id.txtCedula);
            txtNombre = (EditText) findViewById(R.id.txtNombre);
            txtApellido = (EditText) findViewById(R.id.txtApellido);
            cmbSexo = (Spinner)findViewById(R.id.cmbSexo);
            sex = res.getStringArray(R.array.sexo);
            txtDireccion=(EditText)findViewById(R.id.txtDireccion);
            txtCelular=(EditText) findViewById(R.id.txtcelular);




            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex);
            cmbSexo.setAdapter(adapter1);
        }



        public boolean validar() {
            int se=cmbSexo.getSelectedItemPosition();
            String aux = res.getString(R.string.error1);
            String menCel = res.getString(R.string.error5);
            if (Metodos.validar_aux(txtCedula, aux)) return false;
            else if (Metodos.validar_aux(txtNombre, aux)) return false;
            else if (Metodos.validar_aux(txtApellido, aux)) return false;
            else if (Metodos.validar_aux(txtDireccion, aux)) return false;
            else if (Metodos.validarCelular(txtCelular, menCel)) return false;
            else if (se==0){
                if(se==0) {
                    Toast.makeText(this, res.getString(R.string.error4), Toast.LENGTH_SHORT ).show();
                    return false;
                }
            }
            return true;

        }

        public void agregar(View v) {
            if (validar()) {

                String id = Datos.getId();
                ArrayList<Abono> abonos= new ArrayList<>();
                Prestamo prestamo = new Prestamo(id, 0, 0, 0,0,"","", abonos);
                Cliente c = new Cliente(id, txtCedula.getText().toString(), txtNombre.getText().toString(), txtApellido.getText().toString(), cmbSexo.getSelectedItemPosition(), txtDireccion.getText().toString(), txtCelular.getText().toString(), prestamo);

                c.guardar();
                Snackbar.make(v, res.getString(R.string.mensaje_cliente_guardado), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                limpiar();
            }
        }


        public void limpiar(View v) {
            limpiar();
        }

        public void limpiar() {
            txtCedula.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtDireccion.setText("");
            txtCelular.setText("");
            cmbSexo.setSelection(0);

            txtCedula.requestFocus();
            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        public void onBackPressed() {
            finish();
            Intent i = new Intent(AgregarCliente.this, Principal2.class);
            startActivity(i);
        }





    }



