package com.team5.tgdd.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.team5.tgdd.R;
import com.team5.tgdd.presenter.AccountPresenter;

public class ChangePasswordActivity extends AppCompatActivity {
    private TextInputLayout mTextInputLayoutPassword1;
    private TextInputLayout mTextInputLayoutPassword2;

    private TextView mTextViewYes;

    private AccountPresenter accountPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        setTitle("Sửa thông tin");

        // ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        instanceView();

        editInfo();
    }

    private void instanceView(){
        accountPresenter = new AccountPresenter();

        mTextInputLayoutPassword1 = findViewById(R.id.til_password1_edit);
        mTextInputLayoutPassword2 =findViewById(R.id.til_password2_edit);

        mTextViewYes = findViewById(R.id.tv_yes);
    }

    private void editInfo(){


        mTextViewYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();

                Bundle bundle = intent.getBundleExtra("bundle");

                String name = bundle.getString("name");
                String address = bundle.getString("address");

                String pass = mTextInputLayoutPassword1.getEditText().getText().toString();

                if (validatePassword()){
                accountPresenter.changePassword(getApplication(),name,pass,address);
                ChangePasswordActivity.this.finish();
                }

            }
        });
    }

    public boolean validatePassword() {
        if (mTextInputLayoutPassword1.getEditText().getText().toString().length()<8) {
            mTextInputLayoutPassword1.setError("Không được ít hơn 8 ký tự");
            return false;
        } else if (!mTextInputLayoutPassword1.getEditText().getText().toString().equals(mTextInputLayoutPassword2.getEditText().getText().toString())){
            mTextInputLayoutPassword2.setError("Mật khẩu không trùng khớp");
            mTextInputLayoutPassword1.setError(null);
            return false;
        }
        else {
            mTextInputLayoutPassword1.setError(null);
            mTextInputLayoutPassword2.setError(null);
            return true;
        }
    }
}