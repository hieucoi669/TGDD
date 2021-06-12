package com.team5.tgdd.api;

import com.team5.tgdd.model.JsonListSmartPhone;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SmartPhoneService {
    @GET("getProducts")
    Call<JsonListSmartPhone> getSmartPhone();

}
