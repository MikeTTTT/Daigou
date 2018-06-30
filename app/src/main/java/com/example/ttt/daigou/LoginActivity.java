package com.example.ttt.daigou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class LoginActivity extends AppCompatActivity {
    Button btLogin;
    EditText edUsername, edPassword;
    private final String USERNAME = "tinshou";
    private final String PASSWORD = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        btLogin = (Button) findViewById(R.id.bt_login);
        edUsername = (EditText) findViewById(R.id.ed_username);
        edPassword = (EditText) findViewById(R.id.ed_password);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edUsername.getText().toString();
                String pass = edPassword.getText().toString();
                if (user.isEmpty() || pass.isEmpty() ){
                    Toast.makeText(getApplicationContext(), "请输入用户名/密码！！！", LENGTH_LONG).show();
                }else {
                    if (user.equals(USERNAME) && pass.equals(PASSWORD)){
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else{
                        edPassword.setError("用户名/密码不匹配！");
                    }

                }


            }
        });
    }


}
