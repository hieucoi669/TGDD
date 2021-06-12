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

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<SmartPhone> smartPhones;

    Locale localeEN = new Locale("vi", "VN");
    NumberFormat en = NumberFormat.getInstance(localeEN);

// Click

    /*
     Một trình xử lý khi nhấp chuột xác định để giúp Hoạt động dễ dàng giao tiếp với RecyclerView
     */
    private final ShopAdapterOnClickHandler mClickHandler;

    /**
     * Interface tin nhắn onClick.
     */
    public interface ShopAdapterOnClickHandler{
        void onClick(String id);
    }


    public ShopAdapter(Context mContext, ArrayList<SmartPhone> smartPhones, ShopAdapterOnClickHandler mClickHandler) {
        this.mContext = mContext;
        this.smartPhones = smartPhones;
        this.mClickHandler = mClickHandler;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_smartphone, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( @NotNull ViewHolder holder, int position) {
        SmartPhone smartPhone = smartPhones.get(position);

        holder.mTextNameProduct.setText(smartPhone.getName_product());
        holder.mTextPriceProduct.setText(en.format(Double.parseDouble(smartPhone.getPrice_product())) + " VND");
        Picasso.get().load("https://hieuhmph12287-lab5.herokuapp.com/images/"+smartPhone.getImage1()).into(holder.mImageProduct);
    }

    @Override
    public int getItemCount() {
        return smartPhones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageProduct;
        private TextView mTextNameProduct;
        private TextView mTextPriceProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageProduct = itemView.findViewById(R.id.img_item_smartphone);
            mTextNameProduct = itemView.findViewById(R.id.tv_item_name_smartphone);
            mTextPriceProduct = itemView.findViewById(R.id.tv_item_price_smartphone);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            SmartPhone smartPhone =smartPhones.get(adapterPosition);

            mClickHandler.onClick(smartPhone.getId_product());
        }
    }




}
