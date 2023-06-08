package com.example.shopapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItemList;
    private TextView totalPriceTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartItemList = new ArrayList<>(); // 替换为您从数据库中获取购物车列表的逻辑

        cartAdapter = new CartAdapter(cartItemList);
        recyclerView.setAdapter(cartAdapter);

        totalPriceTextView = view.findViewById(R.id.total_price_text_view);
        double totalPrice = calculateTotalPrice(); // 替换为您计算购物车总价值的逻辑
        totalPriceTextView.setText(String.format(Locale.getDefault(), "总价值：%.2f", totalPrice));

        return view;
    }

    private double calculateTotalPrice() {
        // 根据购物车列表计算总价值的逻辑
        // 返回计算得到的总价值
        return 0;
    }
}