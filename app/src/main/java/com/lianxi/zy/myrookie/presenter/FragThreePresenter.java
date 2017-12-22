package com.lianxi.zy.myrookie.presenter;

import com.lianxi.zy.myrookie.bean.FenLeiFatherBean;
import com.lianxi.zy.myrookie.model.FragThreeModel;
import com.lianxi.zy.myrookie.model.IFragThreeModel;
import com.lianxi.zy.myrookie.view.IFragThreeView;

import java.lang.ref.SoftReference;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FragThreePresenter implements  IPresenter<IFragThreeView>{

    IFragThreeModel model;
    private SoftReference<IFragThreeView> softReference;

    public FragThreePresenter(IFragThreeView view) {
        this.model = new FragThreeModel();
        attech(view);
    }


    public  void  getData(){
        model.getData(new Observer<List<FenLeiFatherBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<FenLeiFatherBean> fenLeiFatherBeans) {
               softReference.get().setData(fenLeiFatherBeans);
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
    public void attech(IFragThreeView view) {
        softReference = new SoftReference<IFragThreeView>(view);
    }

    @Override
    public void detech() {
      softReference.clear();
    }
}
