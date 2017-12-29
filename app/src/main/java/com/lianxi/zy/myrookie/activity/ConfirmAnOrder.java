package com.lianxi.zy.myrookie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.adapter.ConfirmAnOrderAdapter;
import com.lianxi.zy.myrookie.bean.CarBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmAnOrder extends AppCompatActivity {
    List<CarBean> list;
    @BindView(R.id.fouth_head_fh)
    ImageView fouthHeadFh;
    @BindView(R.id.fouth_head_gw)
    TextView fouthHeadGw;
    @BindView(R.id.fouth_head_bj)
    TextView fouthHeadBj;
    @BindView(R.id.fouth_foot_hj)
    TextView fouthFootHj;
    @BindView(R.id.fouth_foot_js)
    TextView fouthFootJs;
    @BindView(R.id.fouth_recy)
    RecyclerView fouthRecy;

    List<CarBean> newlist ;
    private int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_an_order);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);




    }

    //接收数据
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void accData(List<CarBean> list) {
        this.list = list;

        newlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CarBean carBean = list.get(i);
            if (carBean.isChecked()){
                newlist.add(carBean);
            }
        }
        Log.i("zyy", "ConfirmAnOrder: " + newlist.size());
        ConfirmAnOrderAdapter adapter =new ConfirmAnOrderAdapter(newlist,ConfirmAnOrder.this);
        fouthRecy.setLayoutManager(new LinearLayoutManager(ConfirmAnOrder.this));
        fouthRecy.addItemDecoration(new DividerItemDecoration(ConfirmAnOrder.this, DividerItemDecoration.VERTICAL));
        fouthRecy.setAdapter(adapter);

        for (int i = 0; i < newlist.size(); i++) {
            CarBean carBean = newlist.get(i);
            int prices = Integer.parseInt(carBean.getPrice());
            price+=prices;
        }

        fouthFootHj.setText("合计：￥" + price);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
