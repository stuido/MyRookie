package com.lianxi.zy.myrookie.model;

import java.util.Map;

import io.reactivex.Observer;

/**
 * Created by ${zy} on 2017/12/21.
 */

public interface IFenlei_Child_Model {

    void  getData(Map<String , String> map, Observer observer);
    void getData(Observer observer);

}
