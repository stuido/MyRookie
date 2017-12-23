package com.lianxi.zy.myrookie.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.dao.CartDao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellingXiangQingActivity extends AppCompatActivity {

    @BindView(R.id.xq_img)
    SimpleDraweeView xqImg;
    @BindView(R.id.xq_name)
    TextView xqName;
    @BindView(R.id.xq_price)
    TextView xqPrice;
    @BindView(R.id.sale)
    TextView salenum;
    @BindView(R.id.join)
    TextView join;
    @BindView(R.id.play_now)
    TextView playNow;
    private String name;
    private String imgUrl;
    private int price;
    private int sale;
    CartDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_selling_xiang_qing);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        imgUrl = intent.getStringExtra("imgUrl");
        price = intent.getIntExtra("price", 0);
        sale = intent.getIntExtra("sale", 0);
        dao=new CartDao(this);
        initData();

    }

    private void initData() {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imgUrl)
                .setAutoPlayAnimations(true)
                .build();
        xqImg.setController(controller);
        xqName.setText(name);
        xqPrice.setText("￥" + price);
        salenum.setText(sale + "");


    }

    @OnClick({R.id.join, R.id.play_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.join:
                ContentValues values=new ContentValues();
                values.put("img",imgUrl);
                values.put("title",name);
                values.put("price",price);
                dao.insert(values);
                Toast.makeText(this,"我要加入购物车",Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_now:
                ContentValues values2=new ContentValues();
                values2.put("img",imgUrl);
                values2.put("title",name);
                values2.put("price",price);
                dao.insert(values2);
                Toast.makeText(this,"我要加入购物车",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
