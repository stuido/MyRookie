package com.lianxi.zy.myrookie.model;

import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FragOneModel implements  IFragOneModel{
    @Override
    public void getData(Observer observer) {
        RetrofitUtils.getApiService().getData("1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
