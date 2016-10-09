package com.example.poorwa.rbd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by poorwa on 8/10/16.
 */
public class ListAdapter extends BaseAdapter {

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

    public ListAdapter(Context c)
    {
        mInflater = LayoutInflater.from(c);
        context = c;
    }


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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.list_item, parent, false);
            v.setTag(R.id.listPicture, v.findViewById(R.id.listPicture));
            v.setTag(R.id.listText, v.findViewById(R.id.listText));
            v.setPadding(5, 5, 5, 5);
        }

        picture = (ImageView) v.getTag(R.id.listPicture);
        name = (TextView) v.getTag(R.id.listText);

        picture.setImageResource(imageIDs[position]);
        name.setText(names[position]);
        name.setPadding(10, 10, 0, 0);

        return v;
    }
}
