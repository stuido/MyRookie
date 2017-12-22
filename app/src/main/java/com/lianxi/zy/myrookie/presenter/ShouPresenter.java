package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.model.ShouModel;
import com.lianxi.zy.myrookie.view.IFragOneView;

import java.lang.ref.SoftReference;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 小傻瓜 on 2017/12/20.
 */

public class ShouPresenter implements IPresenter<IFragOneView>{
    private ShouModel shouModel;
    SoftReference<IFragOneView> mSoftView;
    public ShouPresenter(IFragOneView iFragOneView) {
        this.shouModel =new ShouModel();
        attech(iFragOneView);
    }
    @Override
    public void attech(IFragOneView view) {
        mSoftView=new SoftReference<IFragOneView>(view);
    }
    @Override
    public void detech() {
        mSoftView.clear();
    }


    public void getDataShou(){
        shouModel.getData(new Observer<List<ShouYeBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(List<ShouYeBean> shouYeBeans) {
                Log.i("gss","onNext==="+shouYeBeans.size());
                mSoftView.get().setShouData(shouYeBeans);
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        });
    }
}
