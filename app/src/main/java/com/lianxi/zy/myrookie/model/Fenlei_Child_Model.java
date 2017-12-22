package com.lianxi.zy.myrookie.model;

import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${zy} on 2017/12/21.
 */

public class Fenlei_Child_Model implements  IFenlei_Child_Model {


    @Override
    public void getData(Map<String, String> map, Observer observer) {
        RetrofitUtils.getApiService().getTwoFenlei(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    @Override
    public void getData(Observer observer) {
        RetrofitUtils.getApiService().getData("1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
