package com.lianxi.zy.myrookie.model;

import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 小傻瓜 on 2017/12/20.
 */

public class ShouModel implements IShouModel{
    @Override
    public void getData(Observer observer) {
        RetrofitUtils.getApiService().getShouData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
