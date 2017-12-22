package com.lianxi.zy.myrookie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.SellingBean;

/**
 * Created by jiajiajia on 2017/12/20.
 */

public class MySellingAdapter extends RecyclerView.Adapter<MySellingAdapter.MySellingViewHolder>{
    Context context;
    SellingBean bean;

    public MySellingAdapter(Context context, SellingBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public MySellingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.f2_item,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnItemClick(view, (int) view.getTag());
            }
        });
        MySellingViewHolder holder=new MySellingViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MySellingViewHolder holder, int position) {
        holder.tv_describe.setText(bean.getList().get(position).getName());
        holder.tv_price.setText("￥"+bean.getList().get(position).getPrice());
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(bean.getList().get(position).getImgUrl())
                .setAutoPlayAnimations(true)
                .build();
        holder.f2_item_img.setController(controller);
        holder.tv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我要加入购物车",Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return bean.getList().size();
    }
    onItemClickListener listener;
    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
    public interface onItemClickListener {
        void OnItemClick(View view, int position);
    }
    class MySellingViewHolder extends RecyclerView.ViewHolder{
        TextView tv_describe,tv_price,tv_play;
        SimpleDraweeView f2_item_img;
        public MySellingViewHolder(View itemView) {
            super(itemView);
            tv_describe=itemView.findViewById(R.id.tv_describe);
            tv_price=itemView.findViewById(R.id.tv_price);
            f2_item_img=itemView.findViewById(R.id.f2_item_img);
            tv_play=itemView.findViewById(R.id.buy_now);
        }
    }
}
