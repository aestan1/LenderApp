    package com.example.estan.lenderapp;

    import android.content.Intent;
    import android.content.res.Resources;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.view.View;

    import com.google.firebase.database.DataSnapshot;
    import com.google.firebase.database.DatabaseError;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;
    import com.google.firebase.database.ValueEventListener;

    import java.util.ArrayList;

    public class Principal extends AppCompatActivity  implements AdaptadorCliente.OnClienteClickListener{
        private RecyclerView listado;
        private ArrayList<Cliente> clientes;
        private Resources res;
        private AdaptadorCliente adapter;
        private LinearLayoutManager llm;
        private DatabaseReference databaseReference;
        private  final String BD="Clientes";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);




        listado = (RecyclerView)findViewById(R.id.lstClientes);
        res = this.getResources();
        clientes = new ArrayList<>();

        adapter = new AdaptadorCliente(this.getApplicationContext(),clientes,this);
        llm = new LinearLayoutManager(this);
        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
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
                adapter.notifyDataSetChanged();
                Datos.setClientes(clientes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



        public void agregar (View v){
            Intent i = new Intent(Principal.this,AgregarCliente.class);
            startActivity(i);

        }

        public void agregarA(View v){
            setContentView(R.layout.activity_agregar_abono);
        }


        @Override
        public void onClienteClick(Cliente c) {
            Intent i = new Intent(Principal.this,VerCliente.class);
            Bundle b = new Bundle();
            b.putString("id",c.getId());
            b.putString("cedula",c.getCedula());
            b.putString("nombre",c.getNombre());
            b.putString("apellido",c.getApellido());
            b.putString("direccion",c.getDireccion());
            b.putString("celular",c.getCelular());
            b.putString("sexo", ""+ c.getSexo());
            b.putString("deudaActual", (""+ c.getPrestamo().getDeudaActual()));
            b.putString("cuotasRestantes", (""+c.getPrestamo().getCuotasRestantes()));


            i.putExtra("datos",b);
            startActivity(i);
        }
    }