package com.lianxi.zy.myrookie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.adapter.MySellingAdapter;
import com.lianxi.zy.myrookie.bean.SellingBean;
import com.lianxi.zy.myrookie.presenter.FragTwoPresenter;
import com.lianxi.zy.myrookie.view.IFragTwoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiajiajia on 2017/12/19.
 */

public class FragmentTwo extends BaseFragment<FragTwoPresenter> implements IFragTwoView {
    @BindView(R.id.rm_rv)
    RecyclerView rmRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.f2, null);
        //调数据
        mPresenter.getSellingData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setSellingData(SellingBean sellingBean) {

        Log.i("sss", "setSellingData: "+sellingBean.getList().size());

        rmRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MySellingAdapter adapter=new MySellingAdapter(getActivity(),sellingBean);
        rmRv.setAdapter(adapter);


    }

    @Override
    public void onCreatePresenter() {
        mPresenter = new FragTwoPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
