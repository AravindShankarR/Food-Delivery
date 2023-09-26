package com.example.fooddelimain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;


public class TopRatedMoreAdapter extends RecyclerView.Adapter<TopRatedMoreAdapter.TopRatedMoreViewHolder> {
    private ArrayList<TopRatedItem> mTopRatedMoreItems;

    private ArrayList<Boolean> isItemFavoritedList;

      // List to track favorited state
    private static ArrayList<Integer> counters;
    private static ArrayList<Double> itemcounts;
    private TextView no_of_items;
    private TextView price;

    public TopRatedMoreAdapter(ArrayList<TopRatedItem> topRatedMoreItems, TextView no_of_items, TextView price) {
        mTopRatedMoreItems = topRatedMoreItems;
        isItemFavoritedList = new ArrayList<>();

        itemcounts = new ArrayList<>();
        this.no_of_items = no_of_items;
        this.price = price;
        counters = new ArrayList<>();
        for (int i = 0; i < topRatedMoreItems.size(); i++) {
            isItemFavoritedList.add(false);
            counters.add(0);
            itemcounts.add(0.0);// Initialize all items as not favorited
        }
    }






    @NonNull
    @Override
    public TopRatedMoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_rated_inside, parent, false);
        return new TopRatedMoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedMoreViewHolder holder, int position) {
        TopRatedItem currentItem = mTopRatedMoreItems.get(position);

        holder.top_rated_image.setImageResource(currentItem.getImageResource());
        holder.food_category.setText(currentItem.getFood_category());
        holder.food_name.setText(currentItem.getFood_name());
        holder.food_price.setText(currentItem.getFood_price());

        holder.quantity.setText(String.valueOf(counters.get(position)));  // Update counter text


        if (isItemFavoritedList.get(position)) {
            holder.heartIcon.setImageResource(R.drawable.ic_heart_full);
        } else {
            holder.heartIcon.setImageResource(R.drawable.fav_no_col);
        }


        holder.plus.setOnClickListener(View ->{
            counters.set(position, counters.get(position) + 1);  // Increment the counter for this item
            holder.updateCount();// Update the UI
            updatetotalcount();
            updateTotalPrice();
        });

        holder.minus.setOnClickListener(View ->{
            int counter = counters.get(position);
            if (counter > 0) {
                counters.set(position, counter - 1);  // Decrement the counter for this item
                holder.updateCount(); // Update the UI
                updatetotalcount();
                updateTotalPrice();
            }



        });







        holder.heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFavorited = isItemFavoritedList.get(position);
                isItemFavoritedList.set(position, !isFavorited);
                notifyDataSetChanged();  // Update the UI to reflect the changes
            }
        });




    }

    @Override
    public int getItemCount() {
        return mTopRatedMoreItems.size();
    }

    private void updateTotalPrice() {
        double totalprice = 0.0;
        for(int i=0;i<mTopRatedMoreItems.size();i++){
            double x = Double.parseDouble(mTopRatedMoreItems.get(i).getFood_price());
            totalprice += x* counters.get(i);
            double amount = counters.get(i)*x;
            itemcounts.set(i,amount);
        }
        price.setText(String.format(Locale.getDefault(), "%.2f", totalprice));



    }
    public String getTotalAmount(){
        return price.getEditableText().toString();
    }
    public ArrayList<Integer> getItemCounts() {
        return counters;
    }

    public double[] getItemAmountsArray() {
        double[] amountsArray = new double[itemcounts.size()];
        for (int i = 0; i < itemcounts.size(); i++) {
            amountsArray[i] = itemcounts.get(i);
        }
        return amountsArray;
    }

    private void updatetotalcount() {
        int totalCount = 0;
        for (Integer counter : counters) {
            totalCount += counter;
        }
        no_of_items.setText(String.valueOf(totalCount));
    }







    public static class TopRatedMoreViewHolder extends RecyclerView.ViewHolder {
        public ImageView top_rated_image;
        public TextView food_category;
        public TextView food_name;
        public TextView food_price;
        public ImageView heartIcon;

        public ImageView plus;
        public ImageView minus;

        public TextView quantity;


        public TopRatedMoreViewHolder(@NonNull View itemView) {
            super(itemView);
            top_rated_image = itemView.findViewById(R.id.food_image);
            food_category = itemView.findViewById(R.id.toprated_foodcategory);
            food_name = itemView.findViewById(R.id.toprated_foodname);
            food_price = itemView.findViewById(R.id.food_money);
            heartIcon = itemView.findViewById(R.id.fav_no_col);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
            quantity = itemView.findViewById(R.id.quantity);

        }


        public void updateCount() {
            quantity.setText(String.valueOf(counters.get(getAdapterPosition())));
        }
    }

}
