
package com.lianxi.zy.myrookie.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hjm.bottomtabbar.BottomTabBar;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.fragment.FragmentFive;
import com.lianxi.zy.myrookie.fragment.FragmentFour;
import com.lianxi.zy.myrookie.fragment.FragmentOne;
import com.lianxi.zy.myrookie.fragment.FragmentThree;
import com.lianxi.zy.myrookie.fragment.FragmentTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ButterKnife.bind(this);

        //Fresco.initialize(this);

        btb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(13)
                .setTabPadding(2, 3, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("主页", R.mipmap.sy2, R.mipmap.sy1, FragmentOne.class)
                .addTabItem("热卖", R.mipmap.wt2, R.mipmap.wt1, FragmentTwo.class)
                .addTabItem("分类", R.mipmap.fl2, R.mipmap.fl1, FragmentThree.class)
                .addTabItem("购物车", R.mipmap.gwc2, R.mipmap.gwc1, FragmentFour.class)
                .addTabItem("我的", R.mipmap.wd2, R.mipmap.wd1, FragmentFive.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TGA", "位置：" + position + "      选项卡：" + name);
                    }
                });
    }
}
