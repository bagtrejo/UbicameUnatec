package com.example.proyectoubicacion.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoubicacion.Activities.DetalleUbicacionActivity;
import com.example.proyectoubicacion.Activities.ListElement;
import com.example.proyectoubicacion.Activities.PrincipalActivity;
import com.example.proyectoubicacion.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleUbicacionActivity.class);
                intent.putExtra("posicion", position);
                intent.putExtra("titulo", mData.get(position).getTitulo());
                intent.putExtra("descripcion", mData.get(position).getDescripcion());
                context.startActivity(intent);
            }
        });

    }

    public void setItems(List<ListElement> items){mData = items;}

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imagen;
        TextView titulo, descripcion;

        ViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardUbicacion);
            imagen = itemView.findViewById(R.id.imagen);
            titulo = itemView.findViewById(R.id.txtTitulo);
            descripcion = itemView.findViewById(R.id.txtDescripcion);

        }

        void bindData(final ListElement item){
            imagen.setImageResource(item.getImagen());
            titulo.setText(item.getTitulo());
            descripcion.setText(item.getDescripcion());
        }

    }
}
