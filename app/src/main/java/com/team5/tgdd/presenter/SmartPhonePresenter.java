package com.team5.tgdd.presenter;

import android.util.Log;

import com.team5.tgdd.model.JsonListSmartPhone;
import com.team5.tgdd.model.SmartPhone;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.api.SmartPhoneService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SmartPhonePresenter {
    SmartPhoneService iService;
    Retrofit retrofitClient;

    private ArrayList<SmartPhone> smartPhones;

    public ArrayList<SmartPhone> getListSmartPhone(){

        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(SmartPhoneService.class);

        iService.getSmartPhone().enqueue(new Callback<JsonListSmartPhone>() {
            @Override
            public void onResponse(Call<JsonListSmartPhone> call, Response<JsonListSmartPhone> response) {
                JsonListSmartPhone jsonListSmartPhone = response.body();
//                smartPhones = jsonSmartPhone.getSmartPhoneList();
            }

            @Override
            public void onFailure(Call<JsonListSmartPhone> call, Throwable t) {
                Log.e("3", t.getMessage());
            }
        });

        return smartPhones;
    }
}
