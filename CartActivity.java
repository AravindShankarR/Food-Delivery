package com.example.fooddelimain;

import android.content.Intent;
import android.media.Image;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ImageButton back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        back_button = findViewById(R.id.back_button);
        RecyclerView recyclerView = findViewById(R.id.cart_recycler);
        Intent intent = getIntent();
        ArrayList<Integer> itemCounts = intent.getIntegerArrayListExtra("counts");
        double[] itemAmountsArray = intent.getDoubleArrayExtra("amounts");

        back_button.setOnClickListener(View -> {
            Intent intent1 = new Intent(this, TopRatedDetails.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);  // Reuse existing instance
            startActivity(intent1);
        });




// Convert the double array to a List
        ArrayList<Double> itemAmounts = new ArrayList<>();
        for (double amount : itemAmountsArray) {
            itemAmounts.add(amount);
        }


        ArrayList<CartItem> cartItems = new ArrayList<>();

        for(int i=0;i<itemAmounts.size();i++){
            if(itemCounts.get(i)>0) {
                cartItems.add(new CartItem("Paneer", "4", itemAmounts.get(i).toString(), itemCounts.get(i).toString()));
            }
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter<CartAdapter.CartViewHolder> adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);
    }
}