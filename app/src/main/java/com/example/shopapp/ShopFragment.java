package com.example.shopapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productList = new ArrayList<>(); // 替换为您从数据库中获取商品列表的逻辑

        shopAdapter = new ShopAdapter(productList, new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                // 处理商品点击事件，跳转到商品介绍页面
                // 传递相应的商品数据给介绍页面
            }
        });

        recyclerView.setAdapter(shopAdapter);
        return view;
    }
}