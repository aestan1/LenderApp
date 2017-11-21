package com.example.estan.lenderapp;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdaptadorCliente.OnClienteClickListener {
    private RecyclerView listado;
    private ArrayList<Cliente> clientes;
    private Resources res;
    private AdaptadorCliente adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private  final String BD="Clientes";
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal2.this,AgregarCliente.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //desde aqui
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
        });//hasta aqui
    }

    public void onBackPressed() {
        finish();
        Intent i = new Intent(Principal2.this, Principal2.class);
        startActivity(i);
    }

    public void agregar (View v){
        Intent i = new Intent(Principal2.this,AgregarCliente.class);
        startActivity(i);

    }

    public void agregarA(View v){
        Intent i = new Intent(Principal2.this,AgregarPrestamo.class);
        startActivity(i);
    }

    @Override
    public void onClienteClick(Cliente c) {
        Intent i = new Intent(Principal2.this,VerCliente.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.nav_camera) {
            Intent anIntent = new Intent(getApplicationContext(), Simulador.class);
            startActivity(anIntent);
        } else if (id == R.id.nav_gallery) {
            Intent anIntent = new Intent(getApplicationContext(), AgregarCliente.class);
            startActivity(anIntent);

        } else if (id == R.id.nav_slideshow) {
            Intent anIntent = new Intent(getApplicationContext(),ReporteClientes.class);
            startActivity(anIntent);
        } else if (id == R.id.nav_manage) {
            Intent anIntent = new Intent(getApplicationContext(),Principal2.class);
            startActivity(anIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






}
