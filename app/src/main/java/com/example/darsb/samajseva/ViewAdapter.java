package com.example.darsb.samajseva;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    Integer[] images = {R.drawable.tgls7,R.drawable.tgls6,R.drawable.tgls5,R.drawable.tgls3,R.drawable.tgl4,R.drawable.tgl242,
            R.drawable.tgl246,R.drawable.tgl323,R.drawable.tgl402,R.drawable.tgl4017,R.drawable.tgls3,R.drawable.tgls5};

    public ViewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView = view.findViewById(R.id.ImageView);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = container;
        vp.removeView(view);

    }
}
