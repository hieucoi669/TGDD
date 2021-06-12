package com.team5.tgdd.api;

import com.team5.tgdd.model.JsonUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AccountService {
    @GET("getUser/{phone_number}")
    Call<JsonUser> getUser(@Path("phone_number") String phone_number);

    @FormUrlEncoded
    @POST("updateUserClient")
    Call<JsonUser> editInfoUser(@Field("phone_number") String phone_number,
                              @Field("password") String password,
                              @Field("full_name") String name,
                              @Field("address") String address);

    @FormUrlEncoded
    @POST("updateUserClient")
    Call<JsonUser> changePassword(@Field("phone_number") String phone_number,
                                @Field("password") String password,
                                @Field("full_name") String name,
                                @Field("address") String address);
}
