package com.lianxi.zy.myrookie.presenter;

import com.lianxi.zy.myrookie.bean.LoginBean;
import com.lianxi.zy.myrookie.model.IloginModel;
import com.lianxi.zy.myrookie.model.LoginModel;
import com.lianxi.zy.myrookie.view.ILoginView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 赵修江 on 2017/12/29
 */

public class LoginPresenter implements IPresenter<ILoginView> {
    IloginModel model;
    private SoftReference<ILoginView> softReference;

    public LoginPresenter(ILoginView view) {
        this.model = new LoginModel();
        attech(view);
    }

    public void gettlogin(String phone, String password) {
        Map<String,String> map=new HashMap<>();
        map.put("phone",phone);
        map.put("password",password);
        model.getData(map ,new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onNext(LoginBean loginBean) {
                softReference.get().getlogin(loginBean);
            }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() {}
        });
    }

    @Override
    public void attech(ILoginView view) {
        softReference = new SoftReference<ILoginView>(view);
    }

    @Override
    public void detech() {
        softReference.clear();
    }
}
