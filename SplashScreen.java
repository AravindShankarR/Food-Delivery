package com.example.fooddelimain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int delay = 2000;
        new Handler().postDelayed(() -> {
            SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
            boolean check = pref.getBoolean("flag",false);

            Intent intent;
            if(check){ //for logged in
                intent = new Intent(this, LoginActivity.class);
            }
            else{ //first time or logged out
                intent = new Intent(this, MainActivity.class);
            }
            startActivity(intent);

        },delay);
    }


}