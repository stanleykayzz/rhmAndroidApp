package com.example.rhm.rhmandroidapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by alvin.ondzounga on 03/06/2017.
 */

public class MyGridAdapter extends BaseAdapter{
    private Context mContext;
    private Integer[] mThumbIds = {
            R.drawable.about5,
            R.drawable.about6,
            R.drawable.about,
            R.drawable.bar1, R.drawable.bar2,
            R.drawable.chambrebg
    };

    public MyGridAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView picture;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            picture = new ImageView(mContext);
            picture.setLayoutParams(new GridView.LayoutParams(500, 500));
            picture.setScaleType(ImageView.ScaleType.CENTER_CROP);
            picture.setPadding(2, 2, 2, 2);
        } else {
            picture = (ImageView) convertView;
        }

        picture.setImageResource(mThumbIds[position]);
        return picture;
    }
}
