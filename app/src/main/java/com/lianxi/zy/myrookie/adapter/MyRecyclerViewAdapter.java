package com.lianxi.zy.myrookie.adapter;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lianxi.zy.myrookie.R;
import com.lianxi.zy.myrookie.bean.ShouYeBean;

import java.util.List;

import butterknife.BindView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolderOne>{
    private Context context;
    private List<ShouYeBean> listShou;
    private  static int TYPEONE=0;
    private  static int TYPETWO=1;
    private LayoutInflater from;

    public MyRecyclerViewAdapter(Context context, List<ShouYeBean> listShou) {
        this.context = context;
        this.listShou = listShou;
    }
    @Override
    public ViewHolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.f1_item, null);
        ViewHolderOne viewHolderOne = new ViewHolderOne(view);
        //判断类型
        from = LayoutInflater.from(parent.getContext());
        //当type==1时：
        if(viewType==TYPETWO){
            //返回item2的类型
            return new ViewHolderOne(from.inflate(R.layout.f1_item2,parent,false));
        }
        //否则
        return new ViewHolderOne(from.inflate(R.layout.f1_item,parent,false));
    }
    @Override
    public void onBindViewHolder(final ViewHolderOne holder, final int position) {
        holder.tv_title.setText(listShou.get(position).getTitle());
        //一
        Uri uri =  Uri.parse(listShou.get(position).getCpOne().getImgUrl());
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        holder.facebook_img.setController(controller);
        //二
        Uri uri1 =  Uri.parse(listShou.get(position).getCpTwo().getImgUrl());
        DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setAutoPlayAnimations(true)
                .build();
        holder.facebook_imgone.setController(controller1);
        //三
        Uri uri2 =  Uri.parse(listShou.get(position).getCpThree().getImgUrl());
        DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                .setUri(uri2)
                .setAutoPlayAnimations(true)
                .build();
        holder.facebook_imgtwo.setController(controller2);
        holder.facebook_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                    .setDuration(200);
                animator.start();
            }
        });
        holder.facebook_imgone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                        .setDuration(200);
                animator.start();
            }
        });
        holder.facebook_imgtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator =  ObjectAnimator.ofFloat(v, "rotationX", 0.0F, 360.0F)
                        .setDuration(200);
                animator.start();
            }
        });
    }
    @Override
    public int getItemCount() {
        if(listShou==null || listShou.size()<=0)
            return 0;
        return listShou.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2==0){
            return  TYPETWO;
        }
        else return TYPEONE;
    }

    public class ViewHolderOne extends RecyclerView.ViewHolder/* implements View.OnClickListener*/ {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.facebook_img)
        SimpleDraweeView facebook_img;
        @BindView(R.id.facebook_imgone)
        SimpleDraweeView facebook_imgone;
        @BindView(R.id.facebook_imgtwo)
        SimpleDraweeView facebook_imgtwo;
        public ViewHolderOne(View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            facebook_img=itemView.findViewById(R.id.facebook_img);
            facebook_imgone=itemView.findViewById(R.id.facebook_imgone);
            facebook_imgtwo=itemView.findViewById(R.id.facebook_imgtwo);
        }
    }
    /**
     * 回调接口
     */
    private OnItemCleck itemCleck =null;
    public interface OnItemCleck{
        void setItemCleck(View view,int position);
    }
    public void setOnItemCleckListener(OnItemCleck itemCleckListener){
        itemCleck=itemCleckListener;
    }
}
