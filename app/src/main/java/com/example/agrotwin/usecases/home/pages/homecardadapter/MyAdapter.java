package com.example.agrotwin.usecases.home.pages.homecardadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrotwin.R;

/**
 * Adaptador para la lista de elementos en la pantalla principal.
 * Este adaptador vincula los datos de las tarjetas con la vista de RecyclerView.
 * @author Adolfo Pérez-Gascón Valls
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    /**
     * Establece la lista de datos de búsqueda y notifica cambios en el conjunto de datos.
     *
     * @param dataSearchList La lista de datos de búsqueda para establecer.
     */
    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    /**
     * Constructor de MyAdapter.
     *
     * @param context El contexto de la aplicación.
     * @param dataList La lista de datos a mostrar en el RecyclerView.
     */
    public MyAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * Crea nuevas instancias de ViewHolder cuando RecyclerView necesita.
     *
     * @param parent   El ViewGroup en el que se inflará el nuevo View.
     * @param viewType El tipo de la nueva vista.
     * @return Un nuevo ViewHolder que contiene una vista de un elemento de la lista.
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    /**
     * Actualiza el contenido de un ViewHolder específico en función de su posición.
     *
     * @param holder   El ViewHolder que debe actualizarse.
     * @param position La posición del elemento en los datos.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                context.startActivity(intent);
            }
        });
    }

    /**
     * Devuelve el número total de elementos en el conjunto de datos.
     *
     * @return El número total de elementos en el conjunto de datos.
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

/**
 * ViewHolder para un elemento de RecyclerView.
 * Contiene una vista de la tarjeta y su título.
 * @author Adolfo Pérez-Gascón Valls
 */
class MyViewHolder extends RecyclerView.ViewHolder{

    TextView recTitle;
    CardView recCard;

    /**
     * Constructor de MyViewHolder.
     *
     * @param itemView La vista inflada que representa un elemento de la lista.
     */
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recTitle = itemView.findViewById(R.id.recTitle);
        recCard = itemView.findViewById(R.id.recCard);
    }
}