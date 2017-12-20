package com.lianxi.zy.myrookie.model;

import android.util.Log;

import com.lianxi.zy.myrookie.bean.XBannerBean;
import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.FieldMap;

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
