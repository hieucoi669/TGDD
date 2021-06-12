package com.team5.tgdd.api;

import com.team5.tgdd.model.Json;
import com.team5.tgdd.model.JsonSmartPhone;
import com.team5.tgdd.model.JsonUser;
import com.team5.tgdd.model.SmartPhone;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DetailProductService {
    @GET("getProducts/{id}")
    Call<JsonSmartPhone> getDetailSmartPhone(@Path("id") String id);

    @FormUrlEncoded
    @POST("addProductToCart")
    Call<Json> addProductToCart(@Field("phone_number") String phone_number,
                                @Field("id_product") String id_product);
}
