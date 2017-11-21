package com.example.estan.lenderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReporteClientes extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Cliente> clientes;
    private DatabaseReference databaseReference;
    private  final String BD="Clientes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_clientes);
        tabla = (TableLayout)findViewById(R.id.tabla);
        clientes=Datos.obtenerClientes();

        databaseReference = FirebaseDatabase.getInstance().getReference();


        databaseReference.child(BD).addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                clientes.clear();
                if (dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Cliente c =snapshot.getValue(Cliente.class);
                        clientes.add(c);
                    }
                }

                Datos.setClientes(clientes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });//hasta aqui

        for (int i = 0; i <clientes.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(clientes.get(i).getCedula());
            c3.setText(clientes.get(i).getNombre());
            c4.setText(clientes.get(i).getApellido());
            c5.setText(""+clientes.get(i).getPrestamo().getDeudaActual());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);

            tabla.addView(fila);


        }

    }
}
