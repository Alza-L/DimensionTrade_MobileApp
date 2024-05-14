package com.example.projectutsmobile2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemDataModel> item;
    public ItemAdapter(List<ItemDataModel> item) {this.item = item;}

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        ItemDataModel item = this.item.get(position);
        holder.item_name.setText(item.getItem_name());
        holder.item_price.setText("$"+item.getItem_price());
        holder.item_stock.setText("Stock: "+item.getItem_stock());
        holder.category_imageId.setImageResource(item.getCategory_imageId());
        holder.category_name.setText(item.getCategory_name());
    }

    @Override
    public int getItemCount() { return item.size(); }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        TextView item_price;
        TextView item_stock;
        ImageView category_imageId;
        TextView category_name;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.name_row);
            item_price = itemView.findViewById(R.id.price_row);
            item_stock = itemView.findViewById(R.id.stock_row);
            category_imageId = itemView.findViewById(R.id.image_row);
            category_name = itemView.findViewById(R.id.category_row);
        }
    }
}
