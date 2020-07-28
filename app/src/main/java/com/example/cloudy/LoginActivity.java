package com.example.cloudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
   private TextInputLayout mLoginUsername,mLoginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       mLoginPassword=findViewById(R.id.loginpassword);
       mLoginUsername=findViewById(R.id.loginusername);

    }


    boolean botheditTextEmptyChecker(String usernameToSet,String passwordToSet){
        if(usernameToSet.trim().isEmpty() && passwordToSet.isEmpty()){
            mLoginPassword.setError("Field can't be empty");
            mLoginPassword.setError("Field can't be empty");
            return true;
        }
        else{
            mLoginUsername.setError(null);
            mLoginPassword.setError(null);
            mLoginUsername.setErrorEnabled(false);
            mLoginPassword.setErrorEnabled(false);
            return false;
        }
    }

    boolean usernameEdittextEmpty(String usernameToSet){
        if(usernameToSet.isEmpty()){
            mLoginUsername.setError("Field can't be empty");
            return true;
        }
        else{
            mLoginUsername.setError(null);
            mLoginUsername.setErrorEnabled(false);
            return false ;

        }
    }

    boolean passwordEdittextEmpty(String passwordToSet){
        if(passwordToSet.trim().isEmpty()){
            mLoginPassword.setError("Field can't be empty");
            return true ;
        }
        else {
            mLoginPassword.setError(null);
            mLoginPassword.setErrorEnabled(false);
            return false;
        }
    }


    public void loginFunction(View v){
        String username=mLoginUsername.getEditText().getText().toString().trim();
        String password=mLoginPassword.getEditText().getText().toString().trim();

        //CHECKING IF ANY FEILD IS EMPTY(RETURNING IF SO)
        if(botheditTextEmptyChecker(username,password) | passwordEdittextEmpty(password)
                | usernameEdittextEmpty(username)){
            return;
        }

        //SETTING FIELDS BACK TO EMPTY
        mLoginUsername.getEditText().setText("");
        mLoginPassword.getEditText().setText("");



    }

}