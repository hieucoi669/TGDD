package com.team5.tgdd.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.team5.tgdd.R;
import com.team5.tgdd.presenter.AccountPresenter;

public class EditInfoActivity extends AppCompatActivity {
    private TextInputLayout mTextInputLayoutName;
    private TextInputLayout mTextInputLayoutAddress;

    private TextView mTextViewYes;

    private AccountPresenter accountPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        setTitle("Sửa thông tin");

        // ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        instanceView();

        editInfo();
    }

    private void instanceView(){
        accountPresenter = new AccountPresenter();

        mTextInputLayoutName = findViewById(R.id.til_name_edit);
        mTextInputLayoutAddress =findViewById(R.id.til_address_edit);

        mTextViewYes = findViewById(R.id.tv_yes);
    }

    private void editInfo(){
        mTextViewYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mTextInputLayoutName.getEditText().getText().toString();
                String address = mTextInputLayoutAddress.getEditText().getText().toString();
                if (validateInput(mTextInputLayoutName) &&validateInput(mTextInputLayoutAddress)){
                accountPresenter.editInfoUser(getApplication(),name,address);
                EditInfoActivity.this.finish();
                }
            }
        });
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

}