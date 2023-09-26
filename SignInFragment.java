package com.example.fooddelimain;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;


public class SignInFragment extends BottomSheetDialogFragment {

    EditText user_name,user_pass;
    private UserViewModel userViewModel;



    Button login_button;
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        dialog.setContentView(R.layout.fragment_sign_in); // Set the content view here

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Set a custom peek height (adjust this value as needed)
        dialog.getBehavior().setPeekHeight(1100); // Set your desired peek height in pixels

        return dialog;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        login_button = view.findViewById(R.id.login_button);




        user_name = view.findViewById(R.id.user_name);
        user_pass = view.findViewById(R.id.user_pass);



        login_button.setOnClickListener(View ->{
            String username = user_name.getEditableText().toString();
            String password = user_pass.getEditableText().toString();

            userViewModel.getUserByUsernamePassword(username,password).observe(getViewLifecycleOwner(),user -> {
                if (user != null) {
                    showAlert();
                } else {
                    showAlertError();
                }
            });




        });

        return view;
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Sign In Successfull!")

                .setPositiveButton("OK", (dialogInterface, i) -> openLoginActivity())
                .setCancelable(false)
                .show();



    }

    private void openLoginActivity() {
        SharedPreferences pref = requireActivity().getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("flag", true);
        editor.apply();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }



    private void showAlertError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Alert")
                .setMessage("Login Failed. Try Again")
                .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss())
                .setCancelable(false)
                .show();
    }






}

