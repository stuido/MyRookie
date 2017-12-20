package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.model.FragOneModel;
import com.lianxi.zy.myrookie.model.IFragOneModel;
import com.lianxi.zy.myrookie.view.IFragOneView;

import java.lang.ref.SoftReference;
import java.util.List;

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
        model.getData(new Observer<List<XBannerBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(List<XBannerBean> xBannerBeans) {
                Log.i("gss","onNext"+xBannerBeans.size());
                softReference.get().setData(xBannerBeans);
            }
            @Override
            public void onError(Throwable e) {
                Log.i("gss","onError"+e);
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
