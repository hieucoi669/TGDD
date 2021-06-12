package com.team5.tgdd.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.team5.tgdd.model.JsonUser;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.api.SignUpService;
import com.team5.tgdd.view.LoginActivity;
import com.team5.tgdd.view.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUpPresenter {
    private static final String regex =  "^0\\d{9}$";
    SignUpService iService;
    Retrofit retrofitClient;
    public void createUser(String phoneNumber, String password, String name, String address, Context context) {
        retrofitClient = RetrofitClient.getInstance();
        iService = retrofitClient.create(SignUpService.class);
        iService.createUser(phoneNumber, password, name, address).enqueue(new Callback<JsonUser>() {
            @Override
            public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                if (response != null) {
                    JsonUser json = response.body();
                    Log.e("OKKKKKK", json.toStringUser());
                    if (validateErrorCode(json.getERROR_CODE())) {
                        if (json.getERROR_MASSAGE().equals("OK")) {
                            saveData(phoneNumber,password,context);
                            Toast.makeText(context, "Tài khoản tạo thành công.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        } else if (json.getERROR_MASSAGE().equals("Account Exists")) {
                            Toast.makeText(context, "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "Thất bại! Vui lòng thử lại.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<JsonUser> call, Throwable t) {
                Toast.makeText(context, "Lỗi sever! Vui lòng thử lại!", Toast.LENGTH_LONG).show();
            }
        });
    }
    private boolean validateErrorCode(String error) {
        if (error.equals("200")) {
            return true;
        }
        return false;
    }
    public boolean validateInput(TextInputLayout inputLayout) {
        if (inputLayout.getEditText().getText().toString().isEmpty()) {
            inputLayout.setError("Không được để trống.");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }
    public boolean validatePhoneNumber(TextInputLayout inputLayout) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLayout.getEditText().getText().toString());
        if (inputLayout.getEditText().getText().toString().isEmpty()) {
            inputLayout.setError("Không được để trống.");
            return false;
        } else if (!matcher.find()){
            inputLayout.setError("SĐT không đúng định dạng. VD: 0x xxx xxxx (10 ký tự).");
            return false;
        }
        else {
            inputLayout.setError(null);
            return true;
        }
    }

    public boolean validatePassword(TextInputLayout pass1,TextInputLayout pass2) {
        if (pass1.getEditText().getText().toString().length()<8) {
            pass1.setError("Không được ít hơn 8 ký tự");
            return false;
        } else if (!pass1.getEditText().getText().toString().equals(pass2.getEditText().getText().toString())){
            pass2.setError("Mật khẩu không trùng khớp");
            pass1.setError(null);
            return false;
        }
        else {
            pass1.setError(null);
            pass2.setError(null);
            return true;
        }
    }

    public void openLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public void saveData(String phoneNumber,String password,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone_number",phoneNumber);
        editor.putString("pass_word",password);
        editor.apply();
    }
}
