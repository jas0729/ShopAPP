package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MerchantManagementActivity extends AppCompatActivity {
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_management);

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 执行退出登录的逻辑
                logout();
            }
        });
    }

    private void logout() {
        // 清除登录状态，例如清除保存的用户信息或登录标记
        // ...

        // 跳转回开始时的主页面，即登录界面
        Intent intent = new Intent(MerchantManagementActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 清除之前的所有Activity栈
        startActivity(intent);
        finish();
    }
}