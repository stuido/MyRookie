package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.model.ShouModel;
import com.lianxi.zy.myrookie.view.IFragOneView;
import com.lianxi.zy.myrookie.view.IShouView;

import java.lang.ref.SoftReference;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 小傻瓜 on 2017/12/20.
 */

public class ShouPresenter implements IPresenter<IShouView>{
    private ShouModel shouModel;
    SoftReference<IShouView> iShouView;
    public ShouPresenter(IShouView iShouView) {
        this.shouModel =new ShouModel();
        attech(iShouView);
    }
    @Override
    public void attech(IShouView view) {
        iShouView=new SoftReference<IShouView>(view);
    }
    @Override
    public void detech() {
        iShouView.clear();
    }
    public void getDataShou(){
        shouModel.getData(new Observer<List<ShouYeBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(List<ShouYeBean> shouYeBeans) {
                Log.i("gss","onNext==="+shouYeBeans.size());
                iShouView.get().setShouData(shouYeBeans);
            }
            @Override
            public void onError(Throwable e) {
                Log.i("gss","onError==="+e);
            }
            @Override
            public void onComplete() {

            }
        });
    }
}
