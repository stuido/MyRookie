package com.lianxi.zy.myrookie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.CarBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${zy} on 2017/12/29.
 */

public class ConfirmAnOrderAdapter extends RecyclerView.Adapter<ConfirmAnOrderAdapter.ConfirmAnOrderViewHolder> {
    List<CarBean> list;
    Context context;


    public ConfirmAnOrderAdapter(List<CarBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ConfirmAnOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.confirmanorder_item, null);
        return new ConfirmAnOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConfirmAnOrderViewHolder holder, int position) {

        CarBean carBean = list.get(position);
        holder.carTitle.setText(carBean.getTitle());
        holder.carPrice.setText("¥:"+carBean.getPrice());
        DraweeController build = Fresco.newDraweeControllerBuilder().setUri(carBean.getImg()).build();
        holder.carSd.setController(build);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ConfirmAnOrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.car_sd)
        SimpleDraweeView carSd;
        @BindView(R.id.car_title)
        TextView carTitle;
        @BindView(R.id.car_price)
        TextView carPrice;
        public ConfirmAnOrderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
