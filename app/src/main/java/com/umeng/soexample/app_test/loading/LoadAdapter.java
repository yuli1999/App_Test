package com.umeng.soexample.app_test.loading;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.umeng.soexample.app_test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * data:2018/11/28
 * author: HJL (磊)
 * function:
 */
public class LoadAdapter extends PagerAdapter {
    private List<Integer> list = new ArrayList<>();

    public LoadAdapter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.img_item,null);
        ImageView pic = view.findViewById(R.id.load_img);
        Integer imgId = list.get(position);
        pic.setImageResource(imgId);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
