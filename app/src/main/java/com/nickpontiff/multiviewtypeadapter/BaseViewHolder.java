package com.nickpontiff.multiviewtypeadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        bindViews(itemView);
    }

    public abstract void bindViews(View view);

    public View getView() {
        return itemView;
    }

    public abstract void bindItem(T t);

}
