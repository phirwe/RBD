package com.example.poorwa.rbd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by poorwa on 8/10/16.
 */
public class SearchListAdapter extends BaseAdapter {



    private Context context;
    private int width;
    private final LayoutInflater mInflater;
    private List<String> result;

    public SearchListAdapter(Context c, List<String> names)
    {
        mInflater = LayoutInflater.from(c);
        context = c;
        result = names;
    }


    public int getCount() {
        return result.size();
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
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.search_list_item, parent, false);
            v.setTag(R.id.searchListText, v.findViewById(R.id.searchListText));
            v.setPadding(5, 5, 5, 5);
        }

        name = (TextView) v.getTag(R.id.searchListText);

        name.setText(result.get(position));
        name.setPadding(10, 10, 0, 0);

        return v;
    }
}
