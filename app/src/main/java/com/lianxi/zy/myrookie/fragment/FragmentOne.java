package com.lianxi.zy.myrookie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.adapter.MyRecyclerViewAdapter;
import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.presenter.FragOnePresenter;
import com.lianxi.zy.myrookie.presenter.ShouPresenter;
import com.lianxi.zy.myrookie.view.IFragOneView;
import com.lianxi.zy.myrookie.view.IShouView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentOne extends BaseFragment<FragOnePresenter> implements IFragOneView,IShouView{
    private View view;
    @BindView(R.id.xbanner_banner)
    XBanner xBanner;
    private List<String> images;
    private List<String> title;
    private Unbinder unbinder;
    private ShouPresenter shouPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            view=inflater.inflate(R.layout.f1,container,false);
        }
        unbinder=ButterKnife.bind(this,view);
        //获取轮播图数据
        mPresenter.getData();
        //获取首页数据
        shouPresenter.getDataShou();
        return view;
    }
    /**
     * 获取xBanner的数据
     * @param xBannerBean
     */
    @Override
    public void setData(List<XBannerBean> xBannerBean) {
        Log.i("Sss", "setData: "+xBannerBean.size());
        //XBanner
        setXbanner(xBannerBean);
    }
    /**
     * 首页的展示
     * @param shouYeBean
     */
    @Override
    public void setShouData(List<ShouYeBean> shouYeBean) {
        Log.i("gss===","setShouData"+shouYeBean.size());

        MyRecyclerViewAdapter myRecyclerViewAdapter=new MyRecyclerViewAdapter(getContext(),shouYeBean);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    /**
     * xbanner轮播图
     * @param
     */
    private void setXbanner(List<XBannerBean> xBannerBean) {
        images = new ArrayList<>();
        title=new ArrayList<>();
        for (int i = 0; i <xBannerBean.size(); i++) {
            images.add(xBannerBean.get(i).getImgUrl());
            title.add(xBannerBean.get(i).getName());
            Log.i("==homeBean==", "setXbanner: " + xBannerBean.get(i).getImgUrl()+xBannerBean.get(i).getName());
        }
        // 为XBanner绑定数据
        xBanner.setData(images, title);
        // 设置XBanner的页面切换特效
        //xBanner.setPoinstPosition(XBanner.BOTTOM);
        //xBanner.setPageTransformer(Transformer.ZoomCenter);
        // 设置XBanner的页面切换特效，选择一个即可，总的大概就这么多效果啦，欢迎使用
        //xBanner.setPageTransformer(Transformer.Default);//横向移动
        //xBanner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
        xBanner.setPageTransformer(Transformer.Rotate);  //单页旋转
        //xBanner.setPageTransformer(Transformer.Cube);    //立体旋转
        //xBanner.setPageTransformer(Transformer.Flip);  // 反转效果
        //xBanner.setPageTransformer(Transformer.Accordion); //三角换页
        //xBanner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
        //xBanner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
        //xBanner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
        //xBanner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
        //xBanner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
        //xBanner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面
        // XBanner适配数据
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });
        // 设置XBanner页面切换的时间，即动画时长
        xBanner.setPageChangeDuration(2000);
    }
    /**
     * 创建p 类
     */
    @Override
    public void onCreatePresenter() {
        mPresenter = new FragOnePresenter(this);
        shouPresenter = new ShouPresenter(this);
    }
}
