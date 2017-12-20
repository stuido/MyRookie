package com.lianxi.zy.myrookie.retrofit;


import com.lianxi.zy.myrookie.bean.XBannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ${张洋洋}
 * @author zy
 */

public interface ApiService {

  public final  static   String BASE_URl = "http://112.124.22.238:8081/course_api/";
  /**
   * http://112.124.22.238:8081/course_api/banner/query?type=1
   */
  @GET("banner/query?")
  Observable<XBannerBean> getData(@Path("type") String type);
}
