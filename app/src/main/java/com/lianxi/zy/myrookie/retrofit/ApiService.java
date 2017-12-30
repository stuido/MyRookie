package com.lianxi.zy.myrookie.retrofit;


import com.lianxi.zy.myrookie.bean.FenLeiFatherBean;
import com.lianxi.zy.myrookie.bean.FenLeiSonBean;
import com.lianxi.zy.myrookie.bean.LoginBean;
import com.lianxi.zy.myrookie.bean.SellingBean;
import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by ${张洋洋}
 * @author zy
 */

public interface ApiService {

    public final static String BASE_URl = "http://112.124.22.238:8081/course_api/";

    /**
     * http://112.124.22.238:8081/course_api/banner/query?type=1
     */
    @GET("banner/query")
    Observable<List<XBannerBean>> getData(@Query("type") String type);

    //首页
    @GET("campaign/recommend")
    Observable<List<ShouYeBean>> getShouData();

    //热卖
    @GET("wares/hot")
    Observable<SellingBean> getSellingData(@Query("curPage") int curPage, @Query("pageSize") int pageSize);


    //http://112.124.22.238:8081/course_api/category/list //一级分类
    @GET("category/list")
    Observable<List<FenLeiFatherBean>> getFenleiData();

    //fenlei 二级 http://112.124.22.238:8081/course_api/wares/list?categoryId=2&curPage=1&pageSize=10
//  categoryId ? int ??Id
//  curPage ? int ????
//  pageSize ? int ????

    @FormUrlEncoded
    @POST("wares/list")
    Observable<FenLeiSonBean> getTwoFenlei(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("auth/login")
    Observable<LoginBean> getlogin(@FieldMap Map<String, String> map);





}
