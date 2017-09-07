package com.example.zhanggang.zhanggang20170907;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：适配器
 * 时  间：2017/9/7 - 8:17.
 * 创建人：张刚
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<String> list;
    onClicklener onClicklener;

    public void setOnClicklener(MyAdapter.onClicklener onClicklener) {
        this.onClicklener = onClicklener;
    }

    public MyAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        //动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.textView,"alpha",1f,0f,1f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        //点击事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClicklener!=null){
                    onClicklener.setonClick(view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //内部类
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textview)
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //接口
    public interface onClicklener{
        void setonClick(View view);
    }
}
