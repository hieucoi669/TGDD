package com.team5.tgdd.api;

import com.team5.tgdd.model.JsonUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignUpService {
    @FormUrlEncoded
    @POST("createUser")
    Call<JsonUser> createUser(@Field("phone_number") String phone_number,
                              @Field("password") String password,
                              @Field("full_name") String name,
                              @Field("address") String address);
}
