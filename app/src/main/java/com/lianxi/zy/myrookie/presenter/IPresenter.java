package com.lianxi.zy.myrookie.presenter;

/**
 * Created by ${张洋洋} on 2017/11/23.
 */

public interface IPresenter<V> {
    //mvp 绑定
   void attech(V view);
    //解绑
    void detech();
}
