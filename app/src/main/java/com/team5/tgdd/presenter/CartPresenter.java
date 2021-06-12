package com.team5.tgdd.presenter;

import android.util.Log;

import com.team5.tgdd.api.CartService;
import com.team5.tgdd.api.DetailProductService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.Bill;
import com.team5.tgdd.model.Json;
import com.team5.tgdd.model.SmartPhone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartPresenter {
    private CartService iService;
    private Retrofit retrofitClient;
    static String error;

    public void addPayment(Bill bill){

        retrofitClient = RetrofitClient.getInstance();
        iService = retrofitClient.create(CartService.class);

        iService.addPayment(bill)
                .enqueue(new Callback<Json>() {
            @Override
            public void onResponse(Call<Json> call, Response<Json> response) {
                if (response!=null){
                    Json json = response.body();

                    error =json.getERROR_MASSAGE().toString();
                    Log.e("Test", response.body().toString()+"");
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
