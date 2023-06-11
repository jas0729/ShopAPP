package com.example.shopapp.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.shopapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMallActivity extends AppCompatActivity {
    // 声明底部导航栏和 Fragment
    private BottomNavigationView bottomNavigationViewUser;
    private MallFragment mallFragment;
    private CartFragment cartFragment;
    private UserProfileFragment userProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mall);

        // 初始化底部导航栏和 Fragment
        bottomNavigationViewUser = findViewById(R.id.bottom_navigation_user);
        mallFragment = new MallFragment();
        cartFragment = new CartFragment();
        userProfileFragment = new UserProfileFragment();

        // 设置默认显示的 Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_user, mallFragment).commit();

        // 监听底部导航栏点击事件
        bottomNavigationViewUser.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_mall) {
                selectedFragment = mallFragment;
            } else if (itemId == R.id.menu_cart) {
                selectedFragment = cartFragment;
            } else if (itemId == R.id.menu_profile_user) {
                selectedFragment = userProfileFragment;
            }

            // 切换 Fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_user, selectedFragment).commit();
            return true;
        });
    }

}