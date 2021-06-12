package com.team5.tgdd.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team5.tgdd.R;
import com.team5.tgdd.adapter.CartAdapter;
import com.team5.tgdd.api.CartService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.Bill;
import com.team5.tgdd.model.JsonCart;
import com.team5.tgdd.model.SmartPhone;
import com.team5.tgdd.presenter.AccountPresenter;
import com.team5.tgdd.presenter.CartPresenter;
import com.team5.tgdd.presenter.DetailProductPresenter;
import com.team5.tgdd.view.EditInfoActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CartFragment extends Fragment {

    private View view;

    private CartService iService;
    private Retrofit retrofitClient;

    private CartAdapter mAdapter;

    private ProgressBar mProgressBarCart;
    private RecyclerView mRecyclerView;

    private TextView mTextViewTotal, mPayment;

    CartPresenter cartPresenter;
    ArrayList<SmartPhone> temp;
    String total_value = "";

    Locale localeEN = new Locale("vi", "VN");
    NumberFormat en = NumberFormat.getInstance(localeEN);

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        setView();
        mProgressBarCart.setVisibility(View.VISIBLE);
        setList();

        mPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bill bill = new Bill("HD12111",
                        getPhoneNumber(),
                        temp,
                        total_value,
                        "Đang xử lý");
                cartPresenter = new CartPresenter();
                cartPresenter.addPayment(bill);
                Log.e("Test", "clicked");
            }
        });

        return view;
    }

    private void setView() {
        mRecyclerView = view.findViewById(R.id.rv_cart);
        mProgressBarCart = view.findViewById(R.id.pb_loading_cart);
        mTextViewTotal = view.findViewById(R.id.tv_total_cart);
        mPayment = view.findViewById(R.id.payment);
    }

    private void setList() {
        retrofitClient = RetrofitClient.getInstance();
        iService = retrofitClient.create(CartService.class);

        iService.getCart(getPhoneNumber()).enqueue(new Callback<JsonCart>() {
            @Override
            public void onResponse(Call<JsonCart> call, Response<JsonCart> response) {
                JsonCart json = response.body();
                Log.e("ListSize",": "+json.getSmartPhoneList().size());
                mAdapter = new CartAdapter(getContext(), json.getSmartPhoneList());

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                mRecyclerView.setAdapter(mAdapter);
                mProgressBarCart.setVisibility(View.INVISIBLE);
                setTotal(json.getSmartPhoneList());
                temp = json.getSmartPhoneList();
            }

            @Override
            public void onFailure(Call<JsonCart> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi sever! Vui lòng thử lại!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getPhoneNumber() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        String phoneNumber = sharedPreferences.getString("phone_number", null);
        return phoneNumber;
    }

    private void setTotal(ArrayList<SmartPhone> smartPhones) {
        double total=0;
        for (int i=0;i<smartPhones.size();i++){
            total += Double.parseDouble(smartPhones.get(i).getPrice_product());
        }
        mTextViewTotal.setText(en.format(total) + " VND");
        total_value = en.format(total) + " VND";
    }


}