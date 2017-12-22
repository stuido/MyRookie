package com.lianxi.zy.myrookie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.FenLeiFatherBean;

import java.util.List;

/**
 * Created by ${zy} on 2017/12/20.
 */

public class FenLeiFatherAdapter extends BaseAdapter {

    List<FenLeiFatherBean> fenLeiFatherBeans;
    Context context;

    int mSelect = 0;   //选中项
    public void changeSelected(int positon){ //刷新方法
        if(positon != mSelect){
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    public FenLeiFatherAdapter(List<FenLeiFatherBean> fenLeiFatherBeans, Context context) {
        this.fenLeiFatherBeans = fenLeiFatherBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fenLeiFatherBeans.size();
    }

    @Override
    public FenLeiFatherBean getItem(int position) {
        return fenLeiFatherBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        MyViewHodler myViewHodler = null;
        if (myViewHodler == null) {
            view = View.inflate(context, R.layout.fenlei_parent_item, null);
            myViewHodler = new MyViewHodler();
            myViewHodler.mTextParent = (TextView) view.findViewById(R.id.parent_text);

            view.setTag(myViewHodler);

        }else {
            myViewHodler  = (MyViewHodler) view.getTag();
        }
        FenLeiFatherBean item = getItem(position);

        myViewHodler.mTextParent.setText(item.getName());


        return view;
    }

    class MyViewHodler {
        private TextView mTextParent;
    }
}
