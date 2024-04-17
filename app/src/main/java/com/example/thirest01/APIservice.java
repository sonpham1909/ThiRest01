package com.example.thirest01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIservice {
    String DOMAIN = "http://192.168.0.103:3000/api/";

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();



    APIservice apIservice = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIservice.class);


    @GET("xemay")
    Call<List<XeMayModel>> getXe();

    @POST("xemay")
    Call<Void> addXe(@Body XeMayModel xe);



}
