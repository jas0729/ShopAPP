package com.example.shopapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopapp.dbtool.DatabaseHelper;
import com.example.shopapp.merchant.MerchantManagementActivity;
import com.example.shopapp.R;
import com.example.shopapp.user.UserMallActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private RadioGroup rgUserType;
    private Button btnLogin, btnRegister;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        rgUserType = findViewById(R.id.rg_user_type);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int checkedRadioButtonId = rgUserType.getCheckedRadioButtonId();

                if (isInputValid(username, password)) {
                    if (checkedRadioButtonId == R.id.rb_user) {
                        if (databaseHelper.isValidUser(username, password, 1)) {
                            startActivity(new Intent(MainActivity.this, UserMallActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "用户登录失败，请检查账号和密码", Toast.LENGTH_SHORT).show();
                        }
                    } else if (checkedRadioButtonId == R.id.rb_merchant) {
                        if (databaseHelper.isValidUser(username, password, 0)) {
                            startActivity(new Intent(MainActivity.this, MerchantManagementActivity.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "商家登录失败，请检查账号和密码", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "请选择用户类型", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "账号和密码必须为最短6位数字", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    private boolean isInputValid(String username, String password) {
        String regex = "\\d{6,}";
        return username.matches(regex) && password.matches(regex);
    }
}