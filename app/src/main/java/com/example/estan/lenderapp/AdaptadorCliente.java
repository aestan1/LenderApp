package com.example.estan.lenderapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clientes,parent,false);
        return new ClienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ClienteViewHolder holder, int position) {
        final Cliente c = clientes.get(position);


        if(c.getSexo()==1){
            holder.foto.setImageResource(R.drawable.boy2client128);
        }
        else if(c.getSexo()==2){
            holder.foto.setImageResource(R.drawable.girl2client128);
        }

        holder.cedula.setText(c.getCedula());
        holder.nombre.setText(c.getNombre());
        holder.apellido.setText(c.getApellido());
        holder.direccion.setText(c.getDireccion());
        //holder.direccion.setText(c.getPrestamo().getdireccionActual());

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
        private ImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;
        private TextView direccion;


        public ClienteViewHolder(View item){
            super(item);
            foto = (ImageView) item.findViewById(R.id.imgFoto) ;
            cedula = (TextView) item.findViewById(R.id.lblCedula);
            nombre = (TextView) item.findViewById(R.id.lblNombre);
            apellido = (TextView) item.findViewById(R.id.lblApellido);
            direccion = (TextView) item.findViewById(R.id.lblDeuda);
        }
    }

    public interface OnClienteClickListener{
        void onClienteClick(Cliente c);
    }

}
