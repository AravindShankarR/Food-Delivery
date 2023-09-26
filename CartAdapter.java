package com.example.fooddelimain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {


    private final ArrayList<CartItem> cartItems;

    public CartAdapter(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


    @NonNull
    @NotNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartAdapter.CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.ratings.setText(cartItem.getRatings());
        holder.foodname.setText(cartItem.getFood_name());
        holder.price_money.setText(cartItem.getAmount());
        holder.quant.setText(cartItem.getQuantity());

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder{

        public TextView foodname;
        public TextView price_money;
        public TextView ratings;
        public TextView quant;



        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.foodname);
            price_money = itemView.findViewById(R.id.price_money);
            ratings = itemView.findViewById(R.id.ratings);
            quant = itemView.findViewById(R.id.quant);

        }
    }
}
