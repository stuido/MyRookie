package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.model.FragOneModel;
import com.lianxi.zy.myrookie.model.IFragOneModel;
import com.lianxi.zy.myrookie.view.IFragOneView;

import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FragOnePresenter  implements  IPresenter<IFragOneView>{

    IFragOneModel model;
    private SoftReference<IFragOneView> softReference;

    public FragOnePresenter(IFragOneView view) {
        this.model = new FragOneModel();
        attech(view);
    }


    public  void getData(){
        model.getData(new Observer<XBannerBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XBannerBean  xBannerBean) {
                Log.i("sss", "onNext: "+xBannerBean.getName());
                softReference.get().setData(xBannerBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void attech(IFragOneView view) {
        softReference = new SoftReference<IFragOneView>(view);
    }

    @Override
    public void detech() {
        softReference.clear();
    }
}
