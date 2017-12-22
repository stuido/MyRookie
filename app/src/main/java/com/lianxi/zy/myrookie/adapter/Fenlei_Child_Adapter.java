package com.lianxi.zy.myrookie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.FenLeiSonBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${zy} on 2017/12/21.
 */

public class Fenlei_Child_Adapter extends RecyclerView.Adapter<Fenlei_Child_Adapter.Fenlei_Child_ViewHolder> {
    List<FenLeiSonBean.ListBean> list;
    Context context;


    public Fenlei_Child_Adapter(List<FenLeiSonBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Fenlei_Child_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenlei_rv_item, null);

        return new Fenlei_Child_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Fenlei_Child_ViewHolder holder, int position) {
        holder.rvItemPrice.setText("¥:"+list.get(position).getPrice());
        holder.rvItemText.setText(list.get(position).getName());
        Uri uri = Uri.parse(list.get(position).getImgUrl());

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        holder.rvItemImage.setController(controller);
        holder.rvItemImage.getBackground().setAlpha(40);
        //    holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Fenlei_Child_ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rv_item_image)
        SimpleDraweeView rvItemImage;
        @BindView(R.id.rv_item_text)
        TextView rvItemText;
        @BindView(R.id.rv_item_price)
        TextView rvItemPrice;

        public Fenlei_Child_ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
