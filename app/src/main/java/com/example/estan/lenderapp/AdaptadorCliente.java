package com.example.estan.lenderapp;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by Estan on 12/11/2017.
 */

public class AdaptadorCliente extends RecyclerView.Adapter<AdaptadorCliente.ClienteViewHolder> {

    private ArrayList<Cliente> clientes;
    private Resources res;
    private Context context;
    private OnClienteClickListener clickListener;

    public AdaptadorCliente(Context contexto, ArrayList<Cliente>clientes, OnClienteClickListener clickListener){
        this.clientes = clientes;
        this.res = contexto.getResources();
        this.context = contexto;
        this.clickListener = clickListener;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas,parent,false);
        return new ClienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ClienteViewHolder holder, int position) {
        final Cliente c = clientes.get(position);


        holder.cedula.setText(c.getCedula());
        holder.nombre.setText(c.getNombre());
        holder.apellido.setText(c.getApellido());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClienteClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder{

        private TextView cedula;
        private TextView nombre;
        private TextView apellido;


        public ClienteViewHolder(View item){
            super(item);
            cedula = (TextView) item.findViewById(R.id.lblCedula);
            nombre = (TextView) item.findViewById(R.id.lblNombre);
            apellido = (TextView) item.findViewById(R.id.lblApellido);
        }
    }

    public interface OnClienteClickListener{
        void onClienteClick(Cliente c);
    }

}
