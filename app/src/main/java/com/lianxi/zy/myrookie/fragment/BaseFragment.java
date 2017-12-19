package com.lianxi.zy.myrookie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.lianxi.zy.myrookie.presenter.IPresenter;

/**
 * Created by ${张洋洋} on 2017/11/23.
 */

//创建 BaseFragment
public abstract class BaseFragment<P extends IPresenter> extends Fragment {

    P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onCreatePresenter();

    }

    public  abstract  void  onCreatePresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除绑定
        mPresenter.detech();
    }
}
