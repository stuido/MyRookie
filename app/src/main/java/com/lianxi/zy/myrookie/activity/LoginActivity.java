package com.lianxi.zy.myrookie.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.LoginBean;
import com.lianxi.zy.myrookie.fragment.FragmentOne;
import com.lianxi.zy.myrookie.presenter.LoginPresenter;
import com.lianxi.zy.myrookie.util.DESUtil;
import com.lianxi.zy.myrookie.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText mPhoneEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private TextView fh;
    private int code;
    private LoginBean loginBean1;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        fh = findViewById(R.id.fh);
        mPhoneEt = (EditText) findViewById(R.id.et_phone);
        mPasswordEt = (EditText) findViewById(R.id.et_password);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginBtn.setBackgroundColor(Color.BLUE);
                pk();
            }
        });
    }

    private void pk() {
        String phone = mPhoneEt.getText().toString().trim();
        String password1 = mPasswordEt.getText().toString().trim();
        if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(password1)) {
            Toast.makeText(LoginActivity.this, "手机号和密码咋不输填,是不是傻", Toast.LENGTH_LONG).show();
            return;
        } else {
            password = DESUtil.encode("Cniao5_123456", password1);
            LoginPresenter presenter = new LoginPresenter(this);
            presenter.gettlogin(phone, password);
        }
    }


    @Override
    public void getlogin(LoginBean loginBean) {
        code = loginBean.getStatus();
        Log.i("******code*****", "getlogin: " + code);
        if (code == 1) {
            Toast.makeText(LoginActivity.this, "恭喜您,登陆成功", Toast.LENGTH_LONG).show();
            Intent in = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(in);
        } else {
            Toast.makeText(LoginActivity.this, "对不起,登录失败,请验证您的用户名和密码", Toast.LENGTH_LONG).show();
            return;
        }
    }

}
