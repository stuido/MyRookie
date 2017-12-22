package com.lianxi.zy.myrookie.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.adapter.Fenlei_Child_Adapter;
import com.lianxi.zy.myrookie.bean.FenLeiSonBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.presenter.Fenlei_Child_Presenter;
import com.lianxi.zy.myrookie.view.IFenlei_Child_View;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${zy} on 2017/12/20.
 */


@SuppressLint("ValidFragment")
public class Fenlei_Child_Fragment extends BaseFragment<Fenlei_Child_Presenter> implements IFenlei_Child_View {
    int id;
    @BindView(R.id.classify_vp)
    XBanner classifyVp;
    @BindView(R.id.classify_rv)
    RecyclerView classifyRv;
    Unbinder unbinder;
    private View view;

    private List<XBannerBean> xBannerBean;
    private List<String> images;
    private List<String> title;
    private List<FenLeiSonBean.ListBean> list;


    @SuppressLint("ValidFragment")
    public Fenlei_Child_Fragment(int id) {
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fenlei_child, null);
        mPresenter.getDatas();
        mPresenter.getData();

        unbinder = ButterKnife.bind(this, view);
        Log.i("===a", "onCreateView: ");
        return view;
    }

//    public void getId(int id) {
//        id = id;
//        Log.i("===a", "getId: " + id);
//    }

    /**
     *  rv 数据
     * @param fenLeiSonBean
     */
    @Override
    public void setData(FenLeiSonBean fenLeiSonBean) {
        list = fenLeiSonBean.getList();
        Log.i("", "setData:==== "+fenLeiSonBean.getList().size());
        Fenlei_Child_Adapter fenlei_child_adapter = new Fenlei_Child_Adapter(list,getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        classifyRv.setLayoutManager(gridLayoutManager);
        classifyRv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        classifyRv.setAdapter(fenlei_child_adapter);

    }

    /**
     *
     * 轮播图数据
     * @param xBannerBean
     */
    @Override
    public void setData(List<XBannerBean> xBannerBean) {
        Log.i("===", "fenLeiSonBean: " + xBannerBean.size());
        this.xBannerBean = xBannerBean;
        setxBanner();
    }

    @Override
    public int getIds() {
        return id;
    }

    /**
     * 设置轮播
     */
    private void setxBanner() {
        images = new ArrayList<>();
        title = new ArrayList<>();
        for (int i = 0; i < xBannerBean.size(); i++) {
            images.add(xBannerBean.get(i).getImgUrl());
            title.add(xBannerBean.get(i).getName());
            Log.i("==homeBean==", "setXbanner: " + xBannerBean.get(i).getImgUrl() + xBannerBean.get(i).getName());
        }
        // 为XBanner绑定数据
        classifyVp.setData(images, title);
        classifyVp.setPageTransformer(Transformer.Rotate);  //单页旋转
        classifyVp.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });
        // 设置XBanner页面切换的时间，即动画时长
        classifyVp.setPageChangeDuration(2000);
    }

    @Override
    public void onCreatePresenter() {
        mPresenter = new Fenlei_Child_Presenter(this);

        Log.i("===a", "onCreatePresenter: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
