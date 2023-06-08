package com.example.shopapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMallActivity extends AppCompatActivity {
    private Button btnLogout;
    // 声明底部导航栏和 Fragment
    private BottomNavigationView bottomNavigationView;
    private ShopFragment shopFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mall);

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 执行退出登录的逻辑
                logout();
            }
        });

        // 初始化底部导航栏和 Fragment
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        shopFragment = new ShopFragment();
        cartFragment = new CartFragment();
        profileFragment = new ProfileFragment();

        // 设置默认显示的 Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, shopFragment).commit();

        // 监听底部导航栏点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_mall) {
                selectedFragment = shopFragment;
            } else if (itemId == R.id.menu_cart) {
                selectedFragment = cartFragment;
            } else if (itemId == R.id.menu_profile) {
                selectedFragment = profileFragment;
            }

            // 切换 Fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }

    private void logout() {
        // 清除登录状态，例如清除保存的用户信息或登录标记
        // ...

        // 跳转回开始时的主页面，即登录界面
        Intent intent = new Intent(UserMallActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 清除之前的所有Activity栈
        startActivity(intent);
        finish();
    }
}