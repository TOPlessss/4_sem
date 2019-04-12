package com.example.laba2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class VPAdapter extends PagerAdapter
{
    private Context mContext;
    private LayoutInflater inflater;

    public VPAdapter(Context mContext)
    {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return ClassList.getSize();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        View view = inflater.inflate(R.layout.pager_layout, container, false);
        ImageView iv_pager = view.findViewById(R.id.ImageViewPager);
        TextView tv_pager = view.findViewById(R.id.textViewPager);

        if(ClassList.get(position).getHelpText() != null)
        {
            tv_pager.setText(ClassList.get(position).getHelpText());
        }
        else
        {
            tv_pager.setText("Description lost");
        }

        Picasso.get()
                .load(ClassList.get(position).getGraphic())
                .placeholder(R.drawable.image_failed)
                .into(iv_pager);
        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        View view = (View) object;
        container.removeView(view);
    }
}
