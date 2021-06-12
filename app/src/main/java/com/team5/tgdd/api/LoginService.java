package com.team5.tgdd.api;

import com.team5.tgdd.model.JsonUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<JsonUser> login(@Field("phone_number") String email,
                         @Field("password") String password);
}
