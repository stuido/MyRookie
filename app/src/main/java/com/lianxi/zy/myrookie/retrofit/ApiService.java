package com.lianxi.zy.myrookie.retrofit;


import com.lianxi.zy.myrookie.bean.SellingBean;
import com.lianxi.zy.myrookie.bean.ShouYeBean;
import com.lianxi.zy.myrookie.bean.XBannerBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ${张洋洋}
 * @author zy
 */

public interface ApiService {

  public final  static   String BASE_URl = "http://112.124.22.238:8081/course_api/";
  /**
   * http://112.124.22.238:8081/course_api/banner/query?type=1
   * http://112.124.22.238:8081/course_api/campaign/recommend
   */
  @GET("banner/query")
  Observable<List<XBannerBean>> getData(@Query("type") String type);
  @GET("campaign/recommend")
  Observable<List<ShouYeBean>> getShouData();

  @GET("wares/hot")
  Observable<SellingBean> getSellingData(@Query("curPage") int curPage, @Query("pageSize") int pageSize);
}
