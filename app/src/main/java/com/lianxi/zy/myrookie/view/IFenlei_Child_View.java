package com.lianxi.zy.myrookie.view;

import com.lianxi.zy.myrookie.bean.FenLeiSonBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;

import java.util.List;

public interface IFenlei_Child_View {

    void  setData(FenLeiSonBean fenLeiSonBean);
    void  setData(List<XBannerBean> xBannerBean);
    int getIds();
}