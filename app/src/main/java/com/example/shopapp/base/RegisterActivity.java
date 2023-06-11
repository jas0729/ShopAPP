package com.example.shopapp.base;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopapp.R;
import com.example.shopapp.dbtool.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private RadioButton rbUser, rbMerchant;
    private Button btnRegister;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        rbUser = findViewById(R.id.rb_user);
        rbMerchant = findViewById(R.id.rb_merchant);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int userType = rbUser.isChecked() ? 1 : 0;

                if (isInputValid(username, password)) {
                    if (databaseHelper.addUser(username, password, userType)) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败，请重试",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "账号和密码必须为最短6位数字", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isInputValid(String username, String password) {
        String regex = "\\d{6,}";
        return username.matches(regex) && password.matches(regex);
    }

}