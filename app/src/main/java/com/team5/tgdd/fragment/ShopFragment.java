package com.team5.tgdd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team5.tgdd.R;
import com.team5.tgdd.adapter.ShopAdapter;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.api.SmartPhoneService;
import com.team5.tgdd.model.JsonListSmartPhone;
import com.team5.tgdd.view.DetailProductActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShopFragment extends Fragment implements ShopAdapter.ShopAdapterOnClickHandler{
    private SmartPhoneService iService;
    private Retrofit retrofitClient;
    private ShopAdapter shopAdapter;

    private ProgressBar mProgressBarShop;

    private View view;

    private RecyclerView mRecyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop,null);
        setView();
        mProgressBarShop.setVisibility(View.VISIBLE);
        setList();


        return view;
    }

    private void setView(){
        mRecyclerView = view.findViewById(R.id.rv_shop);
        mProgressBarShop = view.findViewById(R.id.pb_shop);
    }

    private void setList(){
        retrofitClient = RetrofitClient.getInstance();
        iService= retrofitClient.create(SmartPhoneService.class);

        iService.getSmartPhone().enqueue(new Callback<JsonListSmartPhone>() {
            @Override
            public void onResponse(Call<JsonListSmartPhone> call, Response<JsonListSmartPhone> response) {
                JsonListSmartPhone json = response.body();
                shopAdapter = new ShopAdapter(getContext(),json.getSmartPhoneList(),ShopFragment.this);

                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

                mRecyclerView.setAdapter(shopAdapter);
                mProgressBarShop.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onFailure(Call<JsonListSmartPhone> call, Throwable t) {
                Toast.makeText(getContext(),"Lỗi sever! Vui lòng thử lại!",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(String id) {
        Intent intent = new Intent(getContext(), DetailProductActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}