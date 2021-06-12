package com.team5.tgdd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.team5.tgdd.R;

public class HomeFragment extends Fragment {
    private View view;

    private ConstraintLayout openSearch;
    private ConstraintLayout openAccount;
    private ConstraintLayout openCart;
    private ConstraintLayout openShop;
    private ConstraintLayout openBill;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null);
        setView();
        openSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new HomeFragment());
            }
        });
        openAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new AccountFragment());
            }
        });
        openShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ShopFragment());
            }
        });
        openCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new HomeFragment());
            }
        });
        openBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new HomeFragment());
            }
        });
        return view;
    }

    private void setView(){
        openSearch = view.findViewById(R.id.open_search);
        openAccount = view.findViewById(R.id.open_account);
        openCart = view.findViewById(R.id.open_cart);
        openShop = view.findViewById(R.id.open_shop);
        openBill = view.findViewById(R.id.open_bill);
    }

    private void openFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();

    }

}