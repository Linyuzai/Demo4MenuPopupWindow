package com.linyuzai.menupopupwindow;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class DisplayView extends LinearLayout {

    private Adapter adapter;

    public DisplayView(Context context) {
        super(context);
    }

    public DisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DisplayView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void notifyUpdate() {
        removeAllViews();
        int count = adapter.getCount();
        for (int position = 0; position < count; position++)
            addView(adapter.getView(position, this));
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        notifyUpdate();
    }

    public Adapter getAdapter() {
        return adapter;
    }

    public abstract static class Adapter {

        protected abstract int getCount();

        protected abstract View getView(int position, ViewGroup parent);

        protected abstract Object getItem(int position);

        protected abstract long getItemId(int position);
    }
}
