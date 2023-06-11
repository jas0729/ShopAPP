package com.example.shopapp.merchant;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.shopapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MerchantManagementActivity extends AppCompatActivity {
    // 声明底部导航栏和 Fragment
    private BottomNavigationView bottomNavigationViewMerchant;
    private ManagementFragment managementFragment;
    private MerchantProfileFragment merchantProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_management);

        // 初始化底部导航栏和 Fragment
        bottomNavigationViewMerchant = findViewById(R.id.bottom_navigation_merchant);
        managementFragment = new ManagementFragment();
        merchantProfileFragment = new MerchantProfileFragment();

        // 设置默认显示的 Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_merchant, managementFragment).commit();

        // 监听底部导航栏点击事件
        bottomNavigationViewMerchant.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_management) {
                selectedFragment = managementFragment;
            } else if (itemId == R.id.menu_profile_merchant) {
                selectedFragment = merchantProfileFragment;
            }

            // 切换 Fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_merchant, selectedFragment).commit();
            return true;
        });
    }

}