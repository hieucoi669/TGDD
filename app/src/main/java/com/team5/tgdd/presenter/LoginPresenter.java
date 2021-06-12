package com.team5.tgdd.presenter;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.team5.tgdd.api.LoginService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.JsonUser;
import com.team5.tgdd.view.MainActivity;
import com.team5.tgdd.view.SignUpActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPresenter {
    private LoginService iService;
    private Retrofit retrofitClient;

    public void login(String phoneNumber, String password, Context context){
        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(LoginService.class);

        iService.login(phoneNumber, password).enqueue(new Callback<JsonUser>() {
            @Override
            public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                JsonUser json = response.body();
                validateForm(json.getERROR_CODE(),json.getERROR_MASSAGE(),context,phoneNumber,password);
            }
            @Override
            public void onFailure(Call<JsonUser> call, Throwable t) {
                Toast.makeText(context,"Lỗi sever! Vui lòng thử lại!",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void validateForm(String errorCode,String errorMessage,Context context,String phoneNumber,String password){
        if (errorCode.equals("200")){
            if (errorMessage.equals("Login Success")){

                saveData(phoneNumber,password,context);

                Toast.makeText(context,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }else if (errorMessage.equals("Wrong Password")){
                Toast.makeText(context,"Sai mật khẩu!",Toast.LENGTH_SHORT).show();
            }else if (errorMessage.equals("Account Not Exists")){
                Toast.makeText(context,"Tài khoản chưa tồn tại",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean validateInput(TextInputLayout inputLayout){
        if (inputLayout.getEditText().getText().toString().isEmpty()){
            inputLayout.setError("Không được để trống.");
            return false;
        }else {
            inputLayout.setError(null);
            return true;
        }
    }
    public void openSignUp(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }

    //Save user login
    public void saveData(String phoneNumber,String password, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone_number",phoneNumber);
        editor.putString("pass_word",password);
        editor.apply();
    }
}
