package com.lianxi.zy.myrookie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lianxi.zy.myrookie.presenter.IPresenter;


/**
 * Created by ${张洋洋}
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {

   P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreatePresenter();

      //  MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType. E_UM_NORMAL);

    }

    public  abstract  void  onCreatePresenter();





    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.detech();
    }
}
