package com.example.cloudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity{
    private TextInputLayout mUsernameInput,mPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUsernameInput=findViewById(R.id.username);
        mPasswordInput=findViewById(R.id.password);

    }


    boolean botheditTextEmptyChecker(String usernameToSet,String passwordToSet){
        if(usernameToSet.trim().isEmpty() && passwordToSet.isEmpty()){
            mUsernameInput.setError("Field can't be empty");
            mPasswordInput.setError("Field can't be empty");
            return true;
        }
        else{
            mUsernameInput.setError(null);
            mPasswordInput.setError(null);
            mUsernameInput.setErrorEnabled(false);
            mPasswordInput.setErrorEnabled(false);
            return false;
        }
    }

    boolean usernameEdittextEmpty(String usernameToSet){
        if(usernameToSet.isEmpty()){
            mUsernameInput.setError("Field can't be empty");
            return true;
        }
        else{
            mUsernameInput.setError(null);
            mUsernameInput.setErrorEnabled(false);
            return false ;

        }
    }

    boolean passwordEdittextEmpty(String passwordToSet){
        if(passwordToSet.trim().isEmpty()){
            mPasswordInput.setError("Field can't be empty");
            return true ;
        }
        else {
            mPasswordInput.setError(null);
            mPasswordInput.setErrorEnabled(false);
            return false;
        }
    }


        public void signUpFunction(View v){
            //SAVING ENTERED DATA INTO VARIABLES
            String usernameToSet=mUsernameInput.getEditText().getText().toString().trim();
            String passwordToSet=mPasswordInput.getEditText().getText().toString().trim();

            //CHECKING IF ANY FEILD IS EMPTY(RETURNING IF SO)
            if(botheditTextEmptyChecker(usernameToSet,passwordToSet) | passwordEdittextEmpty(passwordToSet)
                    | usernameEdittextEmpty(usernameToSet)){
                return;
            }

            //SETTING FIELDS BACK TO EMPTY
            mUsernameInput.getEditText().setText("");
            mPasswordInput.getEditText().setText("");

            //Code for API call and API responce
            Call<SignupResponce> call=RInterfaceProvider.getInterface().signUp(usernameToSet,passwordToSet);
            call.enqueue(new Callback<SignupResponce>() {
                @Override
                public void onResponse(Call<SignupResponce> call, Response<SignupResponce> response)
                {
                    //DISPLAYING API RESPONCE
                    if(!response.isSuccessful()){
                        Toast.makeText(SignUpActivity.this,response.code(),Toast.LENGTH_SHORT).show();
                        return;
                    }
                    SignupResponce signupResponce=response.body();
                    Toast.makeText(SignUpActivity.this,signupResponce.getResponce(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<SignupResponce> call, Throwable t) {
                    Toast.makeText(SignUpActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                }
            });

        }

}