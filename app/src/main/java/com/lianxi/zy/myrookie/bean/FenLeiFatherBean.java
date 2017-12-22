package com.lianxi.zy.myrookie.bean;

import com.google.gson.Gson;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FenLeiFatherBean {

    /**
     * id : 1
     * name : 热门推荐
     * sort : 1
     */

    private int id;
    private String name;
    private int sort;

    public static FenLeiFatherBean objectFromData(String str) {

        return new Gson().fromJson(str, FenLeiFatherBean.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
