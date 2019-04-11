package com.example.lab1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import java.util.Random;

public class MyListAdapter extends ArrayAdapter<CountList>
{

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView number;
        ImageView image;
    }

    public MyListAdapter(Context context, int resource, ArrayList<CountList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String number = getItem(position).getNumber();

        Random random = new Random();

        ViewHolder holder;

        CountList count = new CountList(position + 1);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        holder = new ViewHolder();
        holder.number = (TextView) convertView.findViewById(R.id.textView1);
        holder.image = (ImageView) convertView.findViewById(R.id.image);

        holder.number.setText(count.getNumber());
        holder.image.setImageResource(getImageId(mContext, "m" + String.valueOf(random.nextInt(95) + 1)));

        if (position % 2 == 1)
            convertView.setBackgroundColor(Color.parseColor("#CCCCCC"));
        else
            convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));


        return convertView;
    }
    public static int getImageId(Context context, String imageName)
    {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

}
