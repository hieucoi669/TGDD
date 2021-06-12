package com.team5.tgdd.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.team5.tgdd.R;
import com.team5.tgdd.adapter.SlideImageAdapter;
import com.team5.tgdd.api.DetailProductService;
import com.team5.tgdd.api.RetrofitClient;
import com.team5.tgdd.model.JsonSmartPhone;
import com.team5.tgdd.model.SmartPhone;
import com.team5.tgdd.presenter.DetailProductPresenter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailProductActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;

    private TextView mTextViewName;
    private TextView mTextViewPrice;
    private TextView mTextViewBrand;
    private TextView mTextViewDisplay;
    private TextView mTextViewOS;
    private TextView mTextViewCameraFront;
    private TextView mTextViewCameraBehind;
    private TextView mTextViewCPU;
    private TextView mTextViewRam;
    private TextView mTextViewRom;
    private TextView mTextViewSim;
    private TextView mTextViewPin;

    private TextView mAddToCart;

    private DetailProductService iService;
    private Retrofit retrofitClient;

    private SlideImageAdapter imageProductAdapter;

    private DetailProductPresenter detailProductPresenter;
    Locale localeEN = new Locale("vi", "VN");
    NumberFormat en = NumberFormat.getInstance(localeEN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        setTitle(R.string.detail);

        setView();

        // ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // get ID
        Bundle intent = getIntent().getExtras();
        String idProduct = intent.getString("ID");

        setInfo(idProduct);

        addToCart(idProduct);

    }

    public void setView() {
        mTextViewName = findViewById(R.id.tv_name_product);
        mTextViewPrice = findViewById(R.id.tv_price_product);
        mTextViewBrand = findViewById(R.id.tv_brand_product);
        mTextViewDisplay = findViewById(R.id.tv_display);
        mTextViewOS = findViewById(R.id.tv_os);
        mTextViewCameraFront = findViewById(R.id.tv_front_camera);
        mTextViewCameraBehind = findViewById(R.id.tv_behind_camera);
        mTextViewCPU = findViewById(R.id.tv_cpu);
        mTextViewRam = findViewById(R.id.tv_ram);
        mTextViewRom = findViewById(R.id.tv_rom);
        mTextViewSim = findViewById(R.id.tv_sim);
        mTextViewPin = findViewById(R.id.tv_pin);

        mViewPager = findViewById(R.id.vp_detail);
        mCircleIndicator = findViewById(R.id.ci_detail);

        mAddToCart = findViewById(R.id.addToCart);
    }

    public void setInfo(String id) {

        retrofitClient = RetrofitClient.getInstance();
        iService = retrofitClient.create(DetailProductService.class);

        iService.getDetailSmartPhone(id).enqueue(new Callback<JsonSmartPhone>() {
            @Override
            public void onResponse(Call<JsonSmartPhone> call, Response<JsonSmartPhone> response) {
                JsonSmartPhone json = response.body();
                SmartPhone infoProduct = json.getSmartPhone();

                setInfoView(infoProduct);

                List<String> strings = new ArrayList<>();
                strings.add(infoProduct.getImage1());
                strings.add(infoProduct.getImage2());
                strings.add(infoProduct.getImage3());
                setSlideImage(strings);

            }

            @Override
            public void onFailure(Call<JsonSmartPhone> call, Throwable t) {
                Log.e("Fail", t.getMessage());
            }
        });

    }

    private void setInfoView(SmartPhone infoProduct){
        mTextViewName.setText(infoProduct.getName_product());
        mTextViewPrice.setText(en.format(Double.parseDouble(infoProduct.getPrice_product())) + " VND");
        mTextViewBrand.setText(infoProduct.getBrand_product());
        mTextViewDisplay.setText(infoProduct.getDisplay());
        mTextViewOS.setText(infoProduct.getOs());
        mTextViewCameraFront.setText(infoProduct.getFront_camera());
        mTextViewCameraBehind.setText(infoProduct.getBehind_camera());
        mTextViewCPU.setText(infoProduct.getCpu());
        mTextViewRam.setText(infoProduct.getRam());
        mTextViewRom.setText(infoProduct.getRom());
        mTextViewSim.setText(infoProduct.getSim());
        mTextViewPin.setText(infoProduct.getPin());
    }

    private void setSlideImage(List<String> images){
        imageProductAdapter = new SlideImageAdapter(images);
        mViewPager.setAdapter(imageProductAdapter);

        mCircleIndicator.setViewPager(mViewPager);
        imageProductAdapter.registerDataSetObserver(mCircleIndicator.getDataSetObserver());
    }

    private void addToCart(String idProduct){
        mAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                String phoneNumber = sharedPreferences.getString("phone_number",null);
                detailProductPresenter = new DetailProductPresenter();

                detailProductPresenter.addProductToCart(phoneNumber,idProduct);
            }
        });
    }
}