package com.example.fooddelimain;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    Button signinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView signupbutton;

        signupbutton = findViewById(R.id.signupbutton);

        signinbutton = findViewById(R.id.signinbutton);


        signinbutton.setOnClickListener(v -> {
            SignInFragment signInFragment = new SignInFragment();
            signInFragment.show(getSupportFragmentManager(), signInFragment.getTag());
        });



        signupbutton.setOnClickListener(v -> {
            BottomDrawerFragment bottomDrawerFragment = new BottomDrawerFragment();
            bottomDrawerFragment.show(getSupportFragmentManager(), bottomDrawerFragment.getTag());
        });
    }


}
