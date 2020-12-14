package com.example.proyectoubicacion.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoubicacion.Activities.DetalleUbicacionActivity;
import com.example.proyectoubicacion.Activities.ListElement;
import com.example.proyectoubicacion.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    private List<ListElement> items;
    private List<ListElement> originalItems;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> items, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
        this.originalItems = new ArrayList<>(items);

    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(items.get(position));

        holder.verMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetalleUbicacionActivity.class);
                intent.putExtra("titulo", items.get(position).getTitulo());
                intent.putExtra("descripcion", items.get(position).getDescripcion());
                intent.putExtra("imagen", items.get(position).getImagen());
                intent.putExtra("imagen2", items.get(position).getImagen2());
                intent.putExtra("imagen3", items.get(position).getImagen3());
                context.startActivity(intent);

            }
        });

    }

    public void setItems(List<ListElement> items){items = items;}

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Filter getFilter(){
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListElement> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(originalItems);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ListElement item: originalItems) {
                    if (item.getTitulo().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            items.clear();
            items.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        Button verMas;
        ImageView imagen;
        TextView titulo, descripcion;

        ViewHolder(View itemView){
            super(itemView);
            verMas = itemView.findViewById(R.id.btnVerMas);
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
