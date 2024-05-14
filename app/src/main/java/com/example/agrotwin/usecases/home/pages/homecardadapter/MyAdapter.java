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

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public MyAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

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

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView recTitle;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


        recTitle = itemView.findViewById(R.id.recTitle);

        recCard = itemView.findViewById(R.id.recCard);
    }
}