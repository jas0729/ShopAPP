package com.example.shopapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ProfileFragment extends Fragment {
    private TextView accountTextView;
    private Button logoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        accountTextView = view.findViewById(R.id.account_text_view);
        // 设置用户账号信息，例如从登录时保存的用户数据中获取

        logoutButton = view.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(v -> {
            // 处理退出登录按钮的点击事件
            // 清除购物车数据库中的信息，并跳转到登录页面
        });

        return view;
    }
}