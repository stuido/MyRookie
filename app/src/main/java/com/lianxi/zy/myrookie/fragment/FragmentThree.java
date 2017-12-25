package com.lianxi.zy.myrookie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.adapter.FenLeiFatherAdapter;
import com.lianxi.zy.myrookie.bean.FenLeiFatherBean;
import com.lianxi.zy.myrookie.presenter.FragThreePresenter;
import com.lianxi.zy.myrookie.view.IFragThreeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiajiajia on 2017/12/19.
 */

public class FragmentThree extends BaseFragment<FragThreePresenter> implements IFragThreeView {

    @BindView(R.id.fenlei_listview)
    ListView fenleiListview;
    @BindView(R.id.fenlei_frame)
    FrameLayout fenleiFrame;
    Unbinder unbinder;
    private View view;
    private FragmentManager supportFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getContext(), R.layout.f3, null);

        mPresenter.getData();
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setData(final List<FenLeiFatherBean> fenLeiFatherBeans) {

        Log.i("===", "setData: " + fenLeiFatherBeans.size());
        FenLeiFatherAdapter fenLeiFatherAdapter =new FenLeiFatherAdapter(fenLeiFatherBeans,getContext());
        fenleiListview.setSelector(R.color.cardview_dark_background);
        fenleiListview.setAdapter(fenLeiFatherAdapter);
      //  final Fenlei_Child_Fragment fenlei_child_fragment =new Fenlei_Child_Fragment(fenLeiFatherBeans.get(0).getId());
       //  fenlei_child_fragment.getId(fenLeiFatherBeans.get(0).getId());
        addToStack("shouye",new Fenlei_Child_Fragment(fenLeiFatherBeans.get(0).getId()));
        fenleiListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    fenlei_child_fragment.getId(fenLeiFatherBeans.get(position).getId());
                addToStack("shouye",new Fenlei_Child_Fragment(fenLeiFatherBeans.get(position).getId()));

            }
        });

    }
    public void addToStack(String tag, Fragment fragment) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fenlei_frame, fragment);
        //添加到回退栈
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
    @Override
    public void onCreatePresenter() {
        mPresenter = new FragThreePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
