package com.team5.tgdd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.team5.tgdd.R;
import com.team5.tgdd.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout mPhoneNumberTextInputLayout;
    private TextInputLayout mPasswordTextInputLayout;
    private TextView mLoginTextView;
    private LinearLayout mOpenSigUpTextView;
    private Context context;
    LoginPresenter loginPresenter;

    @SuppressLint({"NewApi", "ResourceAsColor", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login_bnt);

        loginPresenter = new LoginPresenter();
        context = LoginActivity.this;

        //Login
        mLoginTextView = findViewById(R.id.tv_login);

        mPhoneNumberTextInputLayout = findViewById(R.id.til_phone_number);
        mPasswordTextInputLayout = findViewById(R.id.til_pass_word_login);

        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (
                        loginPresenter.validateInput(mPhoneNumberTextInputLayout) &&
                                loginPresenter.validateInput(mPasswordTextInputLayout)
                ) {
                    loginPresenter.login(mPhoneNumberTextInputLayout.getEditText().getText().toString(),
                            mPasswordTextInputLayout.getEditText().getText().toString(), context);
                }
            }
        });

        // Open SignUp
        mOpenSigUpTextView = findViewById(R.id.openSignup);
        mOpenSigUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.openSignUp(context);
            }
        });
    }

}