package com.example.laba2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>
{

    private LayoutInflater inflater;
    private Context mContext;
    private static ClickListener clickListener;

    public ListAdapter(Context mContext)
    {
        this.inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        Context mContext = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        ListViewHolder viewHolder = new ListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ListViewHolder listViewHolder, int position)
    {
        listViewHolder.textView.setText(ClassList.get(position).getName());

        Picasso.get()
                .load(ClassList.get(position).getGraphic())
                .placeholder(R.drawable.image_failed)
                .into(listViewHolder.imageView);

        if (position % 2 == 1)
            listViewHolder.itemView.setBackgroundColor(Color.parseColor("#CCCCCC"));
        else
            listViewHolder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

    }

    @Override
    public int getItemCount()
    {
        return ClassList.getSize();
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView imageView;
        private final TextView textView;

        public ListViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    clickListener.onItemClick(v, getAdapterPosition());
                }
            });
        }

    }
    public interface ClickListener
    {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ClickListener clickListener)
    {
        ListAdapter.clickListener = clickListener;
    }
}
