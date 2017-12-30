package com.lianxi.zy.myrookie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.activity.ConfirmAnOrder;
import com.lianxi.zy.myrookie.adapter.CarAdatper;
import com.lianxi.zy.myrookie.bean.CarBean;
import com.lianxi.zy.myrookie.bean.EventCheck;
import com.lianxi.zy.myrookie.bean.EventPass;
import com.lianxi.zy.myrookie.bean.EventPriceAndNum;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiajiajia on 2017/12/19.
 */

public class FragmentFour extends Fragment {
    @BindView(R.id.fouth_head_fh)
    ImageView fouthHeadFh;
    @BindView(R.id.fouth_head_gw)
    TextView fouthHeadGw;
    @BindView(R.id.fouth_head_bj)
    TextView fouthHeadBj;
    @BindView(R.id.searchedit_header)
    LinearLayout searcheditHeader;
    @BindView(R.id.fouth_recy)
    RecyclerView fouthRecy;
    @BindView(R.id.fouth_foot_ck)
    CheckBox fouthFootCk;
    @BindView(R.id.fouth_foot_hj)
    TextView fouthFootHj;
    @BindView(R.id.fouth_foot_js)
    TextView fouthFootJs;
    @BindView(R.id.searchedit_foot)
    LinearLayout searcheditFoot;
    Unbinder unbinder;
    @BindView(R.id.fouth_foot_count)
    TextView fouthFootCount;
    private View view;
    public CarAdatper adatper;
    int count = 0;
    EventPriceAndNum priceAndNum;

    List<CarBean> list;
    private int counts;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.f4, null);
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initConfig();
        return view;
    }

    private void initConfig() {
        fouthHeadBj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 == 0) {
                    fouthHeadBj.setText("完成");
                    fouthFootJs.setText("删除");
                } else {
                    fouthHeadBj.setText("编辑");
                    fouthFootJs.setText("去结算");
                }
            }
        });
        fouthFootCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatper.changAllListCbState(fouthFootCk.isChecked());
                adatper.notifyDataSetChanged();
            }
        });
        fouthFootJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fouthFootJs.getText().toString();
                if (name.equals("去结算")) {

                    if (counts >= 1) {
                        for (int i = 0; i < list.size(); i++) {
                            CarBean carBean = list.get(i);
                            if (carBean.isChecked()) {
                                EventBus.getDefault().postSticky(list);
                                Intent intent = new Intent(getContext(), ConfirmAnOrder.class);
                                startActivity(intent);
                                break;
                            }
                        }
                    } else {
                        Toast.makeText(getContext(), "请选中一件商品........亲~~~", Toast.LENGTH_SHORT).show();
                    }
                }
                if (name.equals("删除")) {
                    adatper.delete();
                }
            }
        });
    }

    private void initData() {
        adatper = new CarAdatper(getActivity());
        fouthRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        fouthRecy.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        fouthRecy.setAdapter(adatper);
        adatper.getData();
        adatper.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void EventBusData(EventCheck check) {
        fouthFootCk.setChecked(check.isChecked());
    }

    @Subscribe
    public void EventBusData(EventPriceAndNum priceAndNum) {
        this.priceAndNum = priceAndNum;
        fouthFootHj.setText("合计：￥" + priceAndNum.getPrice());
        counts = priceAndNum.getNum() - 1;
        fouthFootCount.setText("(" + counts + ")");
    }

    @Subscribe
    public void EventBusData(EventPass pass) {
        if (pass.isChecked()) {
            adatper.getData();
            adatper.notifyDataSetChanged();
        }
    }

    //接收数据
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void accData(List<CarBean> list) {
        this.list = list;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}