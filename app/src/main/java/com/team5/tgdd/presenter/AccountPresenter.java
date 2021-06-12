package com.team5.tgdd.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.team5.tgdd.api.AccountService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.JsonUser;
import com.team5.tgdd.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AccountPresenter {
    private AccountService iService;
    private Retrofit retrofitClient;

    public void getUser(String phoneNumber, TextView mTextViewPhoneNumber, TextView mTextViewName, TextView mTextViewAddress){

        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(AccountService.class);

        iService.getUser(phoneNumber).enqueue(new Callback<JsonUser>() {
            @Override
            public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                User user = response.body().getUser();
                Log.e("OK", user.toString());
                mTextViewPhoneNumber.setText(user.getPhone_number());
                mTextViewName.setText(user.getFull_name());
                mTextViewAddress.setText(user.getAddress());
            }

            @Override
            public void onFailure(Call<JsonUser> call, Throwable t) {
                Log.e("Fail", t.getMessage());
            }
        });


    }

    public void editInfoUser(Context context,String name,String address){
        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(AccountService.class);
        iService.editInfoUser(getPhoneNumber(context),getPassword(context),name,address).enqueue(new Callback<JsonUser>() {
            @Override
            public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                JsonUser user = response.body();
                Log.e("ABC",user.getUser().toStringUser());
                Toast.makeText(context,"Thông tin mới đã được cập nhật!",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<JsonUser> call, Throwable t) {
                Log.e("Fail", t.getMessage());
            }
        });
    }

    public void changePassword(Context context,String name,String password,String address){
        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(AccountService.class);
        iService.editInfoUser(getPhoneNumber(context),password,name,address).enqueue(new Callback<JsonUser>() {
            @Override
            public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                JsonUser user = response.body();
                Log.e("ABC",user.getUser().toStringUser());
                Toast.makeText(context,"Đổi mật khẩu thành công!",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<JsonUser> call, Throwable t) {
                Log.e("Fail", t.getMessage());
            }
        });
    }



    private String getPhoneNumber(Context context){
        SharedPreferences sharedPreferences =context.getSharedPreferences("user", Context.MODE_PRIVATE);
        return sharedPreferences.getString("phone_number",null);
    }
    private String getPassword(Context context){
        SharedPreferences sharedPreferences =context.getSharedPreferences("user", Context.MODE_PRIVATE);
        return sharedPreferences.getString("pass_word",null);
    }

}
