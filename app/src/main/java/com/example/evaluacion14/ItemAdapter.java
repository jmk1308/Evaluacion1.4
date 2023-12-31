package com.example.evaluacion14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<com.example.evaluacion14.Item> itemList;
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<com.example.evaluacion14.Item> itemList){
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        com.example.evaluacion14.Item item = itemList.get(position);
        holder.imagenView.setImageResource(item.getImge());
        holder.textView.setText(item.getTittle());
    }

    @Override
    public int getItemCount() {
        return itemList.size() ;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenView;
        TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imagenView = itemView.findViewById(R.id.image_list);
            textView = itemView.findViewById(R.id.tittle_list);
        }
    }
}