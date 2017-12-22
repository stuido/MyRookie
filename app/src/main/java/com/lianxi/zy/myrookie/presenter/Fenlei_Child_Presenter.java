package com.lianxi.zy.myrookie.presenter;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.FenLeiSonBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.model.Fenlei_Child_Model;
import com.lianxi.zy.myrookie.view.IFenlei_Child_View;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ${zy} on 2017/12/21.
 */

public class Fenlei_Child_Presenter implements IPresenter<IFenlei_Child_View> {


    Fenlei_Child_Model model;
    private SoftReference<IFenlei_Child_View> softReference;

    public Fenlei_Child_Presenter(IFenlei_Child_View view) {
        this.model = new Fenlei_Child_Model();
        attech(view);
    }


    public  void  getDatas(){
        int ids = softReference.get().getIds();
//  categoryId ? int ??Id
//  curPage ? int ????
//  pageSize ? int ????
        Log.i("categoryId", "getData: "+ids);
        Map<String,String> map =new HashMap<>();
        map.put("categoryId",ids+"");
        map.put("curPage","1");
        map.put("pageSize","10");


        model.getData(map, new Observer<FenLeiSonBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FenLeiSonBean fenLeiSonBean) {
                Log.i("", "setData:==== "+fenLeiSonBean.getList().size());
                 softReference.get().setData(fenLeiSonBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
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
    public void attech(IFenlei_Child_View view) {
        softReference = new SoftReference<IFenlei_Child_View>(view);
    }

    @Override
    public void detech() {
   softReference.clear();
    }
}
