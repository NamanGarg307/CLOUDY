package com.example.cloudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    private Intent mintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

   public void startLogIn(View v){
       mintent=new Intent(this,LoginActivity.class);
       startActivity(mintent);
   }
   public void startSignUp(View v){
        mintent =  new Intent(this,SignUpActivity.class);
        startActivity(mintent);
    }
}