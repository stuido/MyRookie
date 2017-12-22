package com.lianxi.zy.myrookie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SellingXiangQingActivity extends AppCompatActivity {

    @BindView(R.id.xq_img)
    SimpleDraweeView xqImg;
    @BindView(R.id.xq_name)
    TextView xqName;
    @BindView(R.id.xq_price)
    TextView xqPrice;
    @BindView(R.id.sale)
    TextView salenum;
    @BindView(R.id.play_now)
    TextView playNow;
    private String name;
    private String imgUrl;
    private int price;
    private int sale;

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
        initData();

    }

    private void initData() {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imgUrl)
                .setAutoPlayAnimations(true)
                .build();
        xqImg.setController(controller);
        xqName.setText(name);
        xqPrice.setText("￥"+price);
        salenum.setText(sale+"");


    }
}
