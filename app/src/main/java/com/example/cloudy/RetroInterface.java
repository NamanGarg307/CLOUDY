package com.example.cloudy;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroInterface {
    @POST("signup")
    @FormUrlEncoded
    Call<SignupResponce> signUp(@Field("username") String username,
                        @Field("password") String password);
    @POST
    @FormUrlEncoded
    Call<IdPassObject> login(@Field("username") String username);
}
