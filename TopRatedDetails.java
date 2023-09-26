package com.example.fooddelimain;

import android.content.Intent;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopRatedDetails extends AppCompatActivity {


    TextView no_of_items,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated_details);
        no_of_items = findViewById(R.id.no_of_items);
        price = findViewById(R.id.price);
        ConstraintLayout constraintLayout = findViewById(R.id.cart_constraint);

        RecyclerView recyclerView = findViewById(R.id.toprated_details);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<TopRatedItem> topRatedItems = new ArrayList<>();
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "150"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "180"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "300"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "50"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "350"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "100"));

        TopRatedMoreAdapter adapter = new TopRatedMoreAdapter(topRatedItems,no_of_items,price);
        recyclerView.setAdapter(adapter);



        constraintLayout.setOnClickListener(View ->{
            Intent intent = new Intent(this, CartActivity.class);
            intent.putIntegerArrayListExtra("counts", adapter.getItemCounts());
            intent.putExtra("amounts",adapter.getItemAmountsArray());
            intent.putExtra("totalprice",adapter.getTotalAmount());

            startActivity(intent);
        });





    }


}