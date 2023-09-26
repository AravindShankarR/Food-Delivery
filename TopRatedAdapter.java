package com.example.fooddelimain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder> {
    private final ArrayList<TopRatedItem> mtopRatedItems;


    @NonNull
    @NotNull
    @Override
    public TopRatedAdapter.TopRatedViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_rated,parent,false);
        return new TopRatedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopRatedAdapter.TopRatedViewHolder holder, int position) {
        TopRatedItem currentItem = mtopRatedItems.get(position);
        holder.top_rated_image.setImageResource(currentItem.getImageResource());
        holder.food_category.setText(currentItem.getFood_category());
        holder.food_name.setText(currentItem.getFood_name());
        holder.food_price.setText(currentItem.getFood_price());

    }

    @Override
    public int getItemCount() {
        return mtopRatedItems.size();
    }

    public TopRatedAdapter(ArrayList<TopRatedItem> topRatedItems) {
        mtopRatedItems = topRatedItems;

    }

    public static class TopRatedViewHolder extends RecyclerView.ViewHolder{
        public ImageView top_rated_image;
        public TextView food_category;
        public TextView food_name;
        public TextView food_price;
        public TopRatedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            top_rated_image = itemView.findViewById(R.id.top_rated_image);
            food_category = itemView.findViewById(R.id.food_category);
            food_name = itemView.findViewById(R.id.food_name);
            food_price = itemView.findViewById(R.id.food_price);
        }
    }
}
