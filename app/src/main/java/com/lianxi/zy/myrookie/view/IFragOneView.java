package com.lianxi.zy.myrookie.view;

import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;

import java.util.List;

/**
 * Created by ${zy} on 2017/12/20.
 */

public interface IFragOneView {
    void  setData(List<XBannerBean> xBannerBean);
    void setShouData(List<ShouYeBean> shouYeBean);
}
