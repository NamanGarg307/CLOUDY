package com.example.cloudy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RInterfaceProvider {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.2.6:8080/Backendcloudy/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static RetroInterface getInterface(){
        return retrofit.create(RetroInterface.class);
    }

}

