package com.team5.tgdd.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.team5.tgdd.R;
import com.team5.tgdd.presenter.AccountPresenter;
import com.team5.tgdd.view.ChangePasswordActivity;
import com.team5.tgdd.view.EditInfoActivity;

public class AccountFragment extends Fragment {

    private View view;

    private TextView mTextViewPhoneNumber;
    private TextView mTextViewName;
    private TextView mTextViewAddress;

    private TextView mTextViewOpenChangeInfo;
    private TextView mTextViewOpenChangePassword;

    AccountPresenter accountPresenter;

    public AccountFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account,container,false);
        accountPresenter = new AccountPresenter();
        setView();

        accountPresenter.getUser(getPhoneNumber(),mTextViewPhoneNumber,mTextViewName,mTextViewAddress);

        mTextViewOpenChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditInfoActivity.class);
                startActivity(intent);
            }
        });

        mTextViewOpenChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getContext(), ChangePasswordActivity.class);


                Bundle bundle  = new Bundle();
                bundle.putString("name",mTextViewName.getText().toString());
                bundle.putString("address",mTextViewAddress.getText().toString());
                intent.putExtra("bundle",bundle);

                startActivity(intent);
            }
        });
        return view;
    }

    private void setView(){
        mTextViewPhoneNumber = view.findViewById(R.id.tv_phoneNumber_account);
        mTextViewName = view.findViewById(R.id.tv_name_account);
        mTextViewAddress = view.findViewById(R.id.tv_address_account);

        mTextViewOpenChangeInfo = view.findViewById(R.id.tv_edit_info);

        mTextViewOpenChangePassword = view.findViewById(R.id.tv_change_password);
    }

    private String getPhoneNumber() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        String phoneNumber = sharedPreferences.getString("phone_number", null);
        return phoneNumber;
    }

    @Override
    public void onResume() {
        super.onResume();
        accountPresenter.getUser(getPhoneNumber(),mTextViewPhoneNumber,mTextViewName,mTextViewAddress);
    }
}