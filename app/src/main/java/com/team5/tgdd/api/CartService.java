package com.team5.tgdd.api;

import com.team5.tgdd.model.Bill;
import com.team5.tgdd.model.Json;
import com.team5.tgdd.model.JsonCart;
import com.team5.tgdd.model.SmartPhone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CartService {
    @FormUrlEncoded
    @POST("getCart")
    Call<JsonCart> getCart(@Field("phone_number") String email);

    @POST("addBill")
    Call<Json> addPayment(@Body Bill bill);

}
