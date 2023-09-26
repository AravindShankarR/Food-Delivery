package com.example.fooddelimain;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.transition.ArcMotion;
import android.transition.Explode;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView welcome, category, toprated;
    EditText search_bar;
    ConstraintLayout nav_bar;



    ImageButton homeicon,snacksicon,favouriteicon,carticon,offericon;
    View dashboardicon;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dashboardicon = findViewById(R.id.dashboardicon);

        drawerLayout = findViewById(R.id.drawer_layout);
        dashboardicon.setOnClickListener(View -> {
            if (!drawerLayout.isDrawerOpen(findViewById(R.id.dashboard_nav))) {
                drawerLayout.openDrawer(findViewById(R.id.dashboard_nav));
            } else {
                drawerLayout.closeDrawer(findViewById(R.id.dashboard_nav));
            }
        });

        homeicon = findViewById(R.id.homeicon);
        snacksicon = findViewById(R.id.snacksicon);
        favouriteicon = findViewById(R.id.favouriteicon);

        //top_rated_cardview = findViewById(R.id.top_rated_cardview);

        carticon = findViewById(R.id.carticon);
        offericon = findViewById(R.id.offericon);
        homeicon.setBackgroundResource(R.drawable.icon_selector);

        homeicon.setOnClickListener(View ->{
            homeicon.setBackgroundResource(R.drawable.icon_selector);
            snacksicon.setBackgroundResource(R.drawable.card_corner);
            carticon.setBackgroundResource(R.drawable.card_corner);
            offericon.setBackgroundResource(R.drawable.card_corner);
            favouriteicon.setBackgroundResource(R.drawable.card_corner);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


        });
        snacksicon.setOnClickListener(View ->{
            homeicon.setBackgroundResource(R.drawable.card_corner);
            snacksicon.setBackgroundResource(R.drawable.icon_selector);
            carticon.setBackgroundResource(R.drawable.card_corner);
            offericon.setBackgroundResource(R.drawable.card_corner);
            favouriteicon.setBackgroundResource(R.drawable.card_corner);





        });
        favouriteicon.setOnClickListener(View ->{
            homeicon.setBackgroundResource(R.drawable.card_corner);
            snacksicon.setBackgroundResource(R.drawable.card_corner);
            carticon.setBackgroundResource(R.drawable.card_corner);
            offericon.setBackgroundResource(R.drawable.card_corner);
            favouriteicon.setBackgroundResource(R.drawable.icon_selector);


        });
        carticon.setOnClickListener(View ->{
            homeicon.setBackgroundResource(R.drawable.card_corner);
            snacksicon.setBackgroundResource(R.drawable.card_corner);
            carticon.setBackgroundResource(R.drawable.icon_selector);
            offericon.setBackgroundResource(R.drawable.card_corner);
            favouriteicon.setBackgroundResource(R.drawable.card_corner);


        });
        offericon.setOnClickListener(View ->{
            homeicon.setBackgroundResource(R.drawable.card_corner);
            snacksicon.setBackgroundResource(R.drawable.card_corner);
            carticon.setBackgroundResource(R.drawable.card_corner);
            offericon.setBackgroundResource(R.drawable.icon_selector);
            favouriteicon.setBackgroundResource(R.drawable.card_corner);


        });










        ArrayList<Offers_Item> exampleList = new ArrayList<>();
        ArrayList<CategoryItem> categoryItems = new ArrayList<>();
        ArrayList<TopRatedItem> topRatedItems = new ArrayList<>();

        exampleList.add(new Offers_Item(R.drawable.sample));
        exampleList.add(new Offers_Item(R.drawable.sample2));
        exampleList.add(new Offers_Item(R.drawable.sample));
        exampleList.add(new Offers_Item(R.drawable.sample2));


        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));
        categoryItems.add(new CategoryItem(R.drawable.sample2,"Biriyani"));



        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "150"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "150"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "150"));
        topRatedItems.add(new TopRatedItem(R.drawable.sample2, "Biriyani", "Paneer Biriyani", "150"));


        welcome = findViewById(R.id.welcome);
        category = findViewById(R.id.category);
        toprated = findViewById(R.id.toprated);
        search_bar = findViewById(R.id.search_bar);

        RecyclerView recyclerView = findViewById(R.id.recycler_offers);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);

        RecyclerView.Adapter<OffersAdapter.OffersViewHolder> adapter = new OffersAdapter(exampleList);
        recyclerView.setAdapter(adapter);




//        LinearSnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(recyclerView);
//        int paddingStart = getResources().getDimensionPixelSize(R.dimen.recycler_view_padding_start);
//        recyclerView.setPaddingRelative(paddingStart, 0, 0, 0);
//        recyclerView.setClipToPadding(false);

        nav_bar = findViewById(R.id.nav_bar);


        RecyclerView recyclerView1 = findViewById(R.id.recycler_image);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setHasFixedSize(true);
        RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> adapter1 = new CategoryAdapter(categoryItems);
        recyclerView1.setAdapter(adapter1);

        RecyclerView recyclerView2 = findViewById(R.id.recyler_top_rated);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView2.setHasFixedSize(true);
        RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder> adapter2 = new TopRatedAdapter(topRatedItems);
        recyclerView2.setAdapter(adapter2);

        recyclerView2.addOnScrollListener(new HideShowScrollListener() {
            @Override
            public void onHide() {
                hideNavBar();
            }

            @Override
            public void onShow() {
                shownavBar();
            }
        });



    }



    private void shownavBar(){
        nav_bar.setVisibility(View.VISIBLE);
    }
    private void hideNavBar(){
        nav_bar.setVisibility(View.GONE);
    }


    public void openActivityDetails(View view) {

        //set a click listener on that view
        view.setOnClickListener(view1 -> {
            Explode explode = getExplode();
            getWindow().setExitTransition(explode);

            // Call the transition to start the animation
            view1.postDelayed(() -> startActivity(new Intent(this, TopRatedDetails.class),  // Provide the activity options to be used for this window

                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, view1, "animator").toBundle()), 500);

        });
    }

    @NotNull
    private static Explode getExplode() {
        Explode explode = new Explode();

        // Set the path motion if needed (e.g., ArcMotion)
        explode.setPathMotion(new ArcMotion());

        explode.setEpicenterCallback(new Explode.EpicenterCallback() {
            @Override
            public Rect onGetEpicenter(Transition transition) {
                // This function defines the epicenter of the explosion animation.
                // You can specify the epicenter based on your requirements.
                // Here, we're assuming the epicenter to be the center of the screen.

                // Get the root view's dimensions
                Rect rootView = transition.getEpicenter();
                int centerX = rootView.width() / 2;
                int centerY = rootView.height() / 2;

                // Set the epicenter to be the center of the screen
                return new Rect(centerX, centerY, centerX, centerY);
            }
        });

        explode.setDuration(1000);  // Set the animation duration in milliseconds
        return explode;
    }



    public void openMainActivity(View view){
        showLogoutAlert("Are you sure you want to Log out?");
    }


    private void showLogoutAlert(String loginSuccess) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert")
                .setMessage(loginSuccess)
                .setPositiveButton("YES", (dialogInterface, i) -> openMain())
                .setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.dismiss())
                .setCancelable(false)
                .show();
    }

    private void openMain() {
        SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("flag",false);
        editor.apply();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        showAlert("Are you sure you want to Exit?");
    }


    private void showAlert(String loginSuccess) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert")
                .setMessage(loginSuccess)
                .setPositiveButton("YES", (dialogInterface, i) -> finishAffinity())
                .setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.dismiss())
                .setCancelable(false)
                .show();
    }
}
