package com.team5.tgdd.presenter;

import android.util.Log;

import com.team5.tgdd.api.DetailProductService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.Json;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailProductPresenter {
    private DetailProductService iService;
    private Retrofit retrofitClient;

    static String error;



    public void addProductToCart(String phoneNumber, String idProduct) {

        retrofitClient = RetrofitClient.getInstance();
        iService = retrofitClient.create(DetailProductService.class);

        iService.addProductToCart(phoneNumber, idProduct).enqueue(new Callback<Json>() {
            @Override
            public void onResponse(Call<Json> call, Response<Json> response) {
                if (response!=null){
                    Json json = response.body();

                    error =json.getERROR_MASSAGE().toString();
                }
            }

            @Override
            public void onFailure(Call<Json> call, Throwable t) {
                Log.e("Fail", t.getMessage());
            }
        });
        Log.e("ERROR", error+"");
    }

}
