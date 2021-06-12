package com.team5.tgdd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.team5.tgdd.R;
import com.team5.tgdd.model.SmartPhone;

import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<SmartPhone> smartPhones;

    Locale localeEN = new Locale("vi", "VN");
    NumberFormat en = NumberFormat.getInstance(localeEN);


    public CartAdapter(Context mContext, ArrayList<SmartPhone> smartPhones) {
        this.mContext = mContext;
        this.smartPhones = smartPhones;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        SmartPhone smartPhone = smartPhones.get(position);

        holder.mTextNameProduct.setText(smartPhone.getName_product());
        holder.mTextPriceProduct.setText(en.format(Double.parseDouble(smartPhone.getPrice_product())) + " VND");
        Picasso.get().load("https://hieuhmph12287-lab5.herokuapp.com/images/"+smartPhone.getImage1()).into(holder.mImageProduct);
        holder.mTextPriceQnt.setText("0");
    }

    @Override
    public int getItemCount() {
        return smartPhones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageProduct;
        private TextView mTextNameProduct;
        private TextView mTextPriceProduct;
        private TextView mTextPriceQnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageProduct = itemView.findViewById(R.id.img_item_cart);
            mTextNameProduct = itemView.findViewById(R.id.tv_name_product_cart);
            mTextPriceProduct = itemView.findViewById(R.id.tv_price_product_cart);
            mTextPriceQnt = itemView.findViewById(R.id.tv_qnt_product_cart);

        }

    }
}
