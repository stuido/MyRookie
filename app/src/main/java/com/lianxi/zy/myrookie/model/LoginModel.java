package com.lianxi.zy.myrookie.model;

import com.lianxi.zy.myrookie.retrofit.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 赵修江 on 2017/12/29
 */

public class LoginModel implements IloginModel{

//    @Override
//    public void getData(String phone, String password, Observer observer) {
//
//        Map<String, String> map = new HashMap<>();
//        map.put("phone",phone);
//        map.put("password",password);
//
//    }
    @Override
    public void getData(Map<String, String> map, Observer observer) {
        RetrofitUtils.getApiService().getlogin(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
