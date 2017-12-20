package com.lianxi.zy.myrookie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.presenter.FragOnePresenter;
import com.lianxi.zy.myrookie.view.IFragOneView;

/**
 * Created by jiajiajia on 2017/12/19.
 */

public class FragmentOne extends BaseFragment<FragOnePresenter> implements IFragOneView {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            view=inflater.inflate(R.layout.f1,container,false);
        }

        //获取轮播图数据
        mPresenter.getData();

        return view;
    }


    /**
     * 回调轮播数据
     * @param xBannerBean
     */
    @Override
    public void setData(XBannerBean xBannerBean) {
        Log.i("Sss", "setData: "+xBannerBean.getName());
    }

    /**
     * 创建p 类
     */
    @Override
    public void onCreatePresenter() {
        mPresenter =  new FragOnePresenter(this);
    }
}
