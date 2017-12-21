package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.SellingBean;
import com.lianxi.zy.myrookie.model.FragTwoModel;
import com.lianxi.zy.myrookie.model.IFragTwoModel;
import com.lianxi.zy.myrookie.view.IFragTwoView;

import java.lang.ref.SoftReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jiajiajia on 2017/12/20.
 */

public class FragTwoPresenter implements IPresenter<IFragTwoView>{
   IFragTwoModel model;
   private SoftReference<IFragTwoView> softReference;

    public FragTwoPresenter(IFragTwoView view) {
        this.model=new FragTwoModel();
        attech(view);
    }
    public void getSellingData(){
        model.getSellingData(new Observer<SellingBean>(){
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SellingBean sellingBean) {
                Log.i("sss", "onNext: "+sellingBean.getCopyright());
                softReference.get().setSellingData(sellingBean);
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
    public void attech(IFragTwoView view) {
        softReference = new SoftReference<IFragTwoView>(view);
    }

    @Override
    public void detech() {
        softReference.clear();
    }
}
