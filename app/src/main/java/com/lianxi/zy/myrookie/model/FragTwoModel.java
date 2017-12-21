package com.lianxi.zy.myrookie.model;

import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jiajiajia on 2017/12/20.
 */

public class FragTwoModel implements IFragTwoModel{
    @Override
    public void getSellingData(Observer observer) {
        RetrofitUtils.getApiService().getSellingData(1,10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
