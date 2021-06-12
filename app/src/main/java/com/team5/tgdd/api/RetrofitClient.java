package com.team5.tgdd.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;
    public static Retrofit getInstance(){
        if (instance==null){
            instance =new Retrofit.Builder()
                    .baseUrl("https://hieuhmph12287-lab5.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return instance;
    }
}