package com.example.laba2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>
{

    private int numberItems; // Количество итемов
    private static int viewHolderCount; // Количество холдеров

    private Context mContext;

    public ListAdapter(int numberItems, Context mContext)
    {
        this.numberItems = numberItems;
        viewHolderCount = 0;

        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        ListViewHolder viewHolder = new ListViewHolder(view);
        viewHolder.viewHolderIndex.setText("HolderCount: " + viewHolderCount);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position)  // Обновление значения холдера при прокрутке списка
    {
        listViewHolder.bind(position);
    }

    @Override
    public int getItemCount()
    {
        return numberItems;
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {

        TextView listItemView;
        TextView viewHolderIndex;

        public ListViewHolder(@NonNull View itemView)
        {
            super(itemView);

            listItemView = itemView.findViewById(R.id.tv_list_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    // Показываем Toast
                    int positionIndex = getAdapterPosition();

                    Toast toast = Toast.makeText(mContext, "Element " + positionIndex + " was clicked", Toast.LENGTH_SHORT);

                    toast.show();
                }
            });
        }

        void bind(int listIndex) // Метод передает значение итему списка
        {
            listItemView.setText(String.valueOf(listIndex)); //Индекс холдера
        }


    }
}
