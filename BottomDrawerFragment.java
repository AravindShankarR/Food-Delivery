package com.example.fooddelimain;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class BottomDrawerFragment extends BottomSheetDialogFragment {

private UserViewModel userViewModel;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{3,}" +               //at least 3 characters
                    "$");
    EditText name,email,Phone_number,password,confirm_pass;


    Button registerbutton;
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        dialog.setContentView(R.layout.bottom_drawer); // Set the content view here

        // Set a custom peek height (adjust this value as needed)
        dialog.getBehavior().setPeekHeight(1650); // Set your desired peek height in pixels

        return dialog;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_drawer, container, false);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        Phone_number = view.findViewById(R.id.Phone_Number);
        password = view.findViewById(R.id.password);
        confirm_pass = view.findViewById(R.id.confirm_pass);


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);




        registerbutton = view.findViewById(R.id.registerbutton);

        View image = view.findViewById(R.id.already_have_account);
        image.setOnClickListener(View -> dismiss());

        registerbutton.setOnClickListener(View ->{
            String name1 = name.getEditableText().toString();

            String email1 = email.getEditableText().toString();
            String phone_number1 = Phone_number.getEditableText().toString();
            String password1 = password.getEditableText().toString();
            String confirm_pass1 = confirm_pass.getEditableText().toString();


            confirmInput(name1,email1,phone_number1,password1,confirm_pass1);



        });

        return view;
    }

    private void confirmInput(String name1, String email1, String phoneNumber1, String password1, String confirmPass1) {
        if(validateUsername(name1) && validateEmail(email1) &&  validatePhoneNumber(phoneNumber1) && validatePassword(password1)){
            if(password1.equals(confirmPass1)) {

                new InsertUserAsyncTask(name1, password1, phoneNumber1, email1, userViewModel).execute();
                showAlert();
            }
            else {
                Toast.makeText(requireActivity(),"Passwords do not match",Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Successfully Registered!")
                .setMessage("Thank you for Registering")
                .setPositiveButton("OK", (dialogInterface, i) -> openLoginActivity())
                .setCancelable(false)
                .show();



    }

    private void openLoginActivity() {
        Intent intent = new Intent(requireActivity(),MainActivity.class);
        startActivity(intent);
    }

    private boolean validatePhoneNumber(String p) {
        if(p.isEmpty()){
            Phone_number.setError("Field cant be empty");
            return false;
        }
        else if(p.length()!=10){
            Phone_number.setError("Please enter a valid Phone Number");
            return false;
        }
        else{
            Phone_number.setError(null);
            return true;
        }

    }

    private boolean validateEmail(String e) {
        if(e.isEmpty()){
            email.setError("Field cant be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(e).matches()){
            email.setError("Please enter a valid Email ID");
            return false;
        }
        else{
            email.setError(null);
            return true;
        }

    }
    private boolean validateUsername(String n) {


        if (n.isEmpty()) {
            name.setError("Field can't be empty");
            return false;
        } else if (n.length() > 15) {
            name.setError("Username too long");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }
    private boolean validatePassword(String p) {

        if (p.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(p).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }



    private static class InsertUserAsyncTask extends AsyncTask<Void, Void, Void> {
        private final String username;
        private final String password;
        private final String phone_number;
        private final String email;
        private UserViewModel userViewModel;



        public InsertUserAsyncTask(String username, String password, String phone_number, String email, UserViewModel userViewModel) {
            this.username = username;
            this.password = password;
            this.phone_number = phone_number;
            this.email = email;

            this.userViewModel = userViewModel;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setPhone_number(phone_number);
            userViewModel.insertUser(newUser);
            return null;
        }
    }








}

