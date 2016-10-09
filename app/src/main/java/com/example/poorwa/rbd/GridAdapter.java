package com.example.poorwa.rbd;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by poorwa on 6/10/16.
 */
public class GridAdapter extends BaseAdapter {
    Integer[] imageIDs = {
            R.drawable.bigbang,
            R.drawable.hannibal,
            R.drawable.house,
            R.drawable.game_of_thrones,
            R.drawable.nemo,
            R.drawable.up,
            R.drawable.wall,
            R.drawable.toystory
    };

    String[] names = {
            "Accountant",
            "Engineer",
            "Architect",
            "Doctor",
            "Business",
            "Advertising",
            "Stocks",
            "Marketing"
    };

    private Context context;
    private int width;
    private final LayoutInflater mInflater;

    public GridAdapter(Context c)
    {
        mInflater = LayoutInflater.from(c);
        context = c;
    }

    //---returns the number of images---
    public int getCount() {
        return imageIDs.length;
    }

    //---returns the ID of an grid_item---
    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    //---returns an ImageView view---
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, parent, false);
            v.setTag(R.id.gridPicture, v.findViewById(R.id.gridPicture));
            v.setTag(R.id.gridText, v.findViewById(R.id.gridText));
            v.setPadding(10, 10, 10, 10);
        }

        picture = (ImageView) v.getTag(R.id.gridPicture);
        name = (TextView) v.getTag(R.id.gridText);

        picture.setImageResource(imageIDs[position]);
        name.setText(names[position]);

        return v;
    }
}

