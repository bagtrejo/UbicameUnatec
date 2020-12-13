package com.example.proyectoubicacion.Adaptadores;

import android.content.Context;
import android.content.Intent;
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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    private List<ListElement> mData;
    private List<ListElement> mDataAll;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.mDataAll = new ArrayList<>(itemList);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
     //   holder.bindData(mData.get(position));

//        holder.cardView.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        holder.verMas.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        //run on background thread
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ListElement> filteredList = new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(mDataAll);
            }else{
                for(ListElement movie: mDataAll){

                        filteredList.add(movie);

                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }
        //corre solo un hilo
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mData.clear();
            mDataAll.addAll((Collection<? extends ListElement>) filterResults.values);
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
