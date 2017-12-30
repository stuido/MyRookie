package com.lianxi.zy.myrookie.model;

import java.util.Map;

import io.reactivex.Observer;

/**
 * Created by 赵修江 on 2017/12/29
 */

public interface IloginModel {
    void  getData(Map<String , String> map, Observer observer);
}
