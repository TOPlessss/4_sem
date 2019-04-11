package com.example.lab1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<ItemsList>
{
    private static final String TAG = "MyArrayAdapter";

    private Context mContext;
    int mResource;

    static class ViewHolder
    {
        TextView number;
    }


    public MyArrayAdapter(Context context, int resource, ItemsList[] objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String number = getItem(position).getNumber();

                ViewHolder holder;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        holder= new ViewHolder();
        holder.number = (TextView) convertView.findViewById(R.id.textView1);

        ItemsList item = new ItemsList(position + 1);
        holder.number.setText(item.getNumber());

        if (position % 2 == 1)
            convertView.setBackgroundColor(Color.parseColor("#CCCCCC"));
        else
            convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));



        return convertView;
    }
}
