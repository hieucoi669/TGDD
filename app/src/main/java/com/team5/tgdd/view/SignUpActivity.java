package com.team5.tgdd.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.team5.tgdd.R;
import com.team5.tgdd.presenter.SignUpPresenter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private static final String regex = "^0\\d{9}$";
    private TextInputLayout mPhoneNumberTextInputLayout;
    private TextInputLayout mPassword1TextInputLayout;
    private TextInputLayout mPassword2TextInputLayout;
    private TextInputLayout mNameTextInputLayout;
    private TextInputLayout mAddressTextInputLayout;
    private TextView mSignUpTextView;
    private LinearLayout mOpenLoginTextView;
    private Context context;
    private SignUpPresenter signUpPresenter;

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle(R.string.sign_bnt);

        context = SignUpActivity.this;
        signUpPresenter = new SignUpPresenter();

        mPhoneNumberTextInputLayout = findViewById(R.id.til_phone_number);
        mPassword1TextInputLayout = findViewById(R.id.til_pass_word);
        mPassword2TextInputLayout = findViewById(R.id.til_repass_word);
        mNameTextInputLayout = findViewById(R.id.til_name);
        mAddressTextInputLayout = findViewById(R.id.til_address);

        //SignUp
        mSignUpTextView = findViewById(R.id.tv_sign_up);
        mSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameTextInputLayout.getEditText().getText().toString();
                String phone_number = mPhoneNumberTextInputLayout.getEditText().getText().toString();
                String password = mPassword1TextInputLayout.getEditText().getText().toString();
                String address = mAddressTextInputLayout.getEditText().getText().toString();
                if (
                signUpPresenter.validateInput(mNameTextInputLayout) &&
                signUpPresenter.validatePhoneNumber(mPhoneNumberTextInputLayout) &&
                signUpPresenter.validatePassword(mPassword1TextInputLayout,mPassword2TextInputLayout) &&
                signUpPresenter.validateInput(mAddressTextInputLayout)
                ){
                    signUpPresenter.createUser(phone_number,password,name,address,context);
                }
            }
        });
        // Open login
        mOpenLoginTextView = findViewById(R.id.openLogin);
        mOpenLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPresenter.openLogin(context);
            }
        });

    }

}