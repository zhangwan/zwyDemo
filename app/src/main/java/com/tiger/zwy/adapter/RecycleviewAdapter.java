package com.tiger.zwy.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import com.bumptech.glide.request.target.BitmapImageViewTarget;

import com.bumptech.glide.request.transition.Transition;
import com.tiger.zwy.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder> {

    private List<Integer> icons;
    private Context mContext;

    public RecycleviewAdapter(List<Integer> icons, Context context) {
        this.icons = icons;
        mContext = context;
    }

    @Override
    public RecycleviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.img_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecycleviewAdapter.MyViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(icons.get(position)).into(new BitmapImageViewTarget(holder.mImageView){
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                super.onResourceReady(resource, transition);
                holder.mImageView.setImageBitmap(resource);
            }
        });

//        Glide.with(mContext).load(icons.get(position)).apply()
//        Glide.with(mContext).load(icons.get(position)).asBitmap()
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        holder.mImageView.setImageBitmap(resource);
//                    }
//                });
    }

    @Override
    public int getItemCount() {
        return icons==null?0:icons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv);
        }
    }
}
