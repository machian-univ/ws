package com.example.wsapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {
    @POST("user/login")
    Call<LoginResponse> login(@Body LoginModel loginModel);

    @GET("feelings")
    Call<LoginResponse> login();
}
