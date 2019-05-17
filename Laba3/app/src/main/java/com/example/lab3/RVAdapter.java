package com.example.lab3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>
{
    private List<Student> students;
    private Context mContext;

    public RVAdapter(List<Student> students)
    {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rvadapter, viewGroup, false);
//        ViewHolder holder = new ViewHolder(view);
        return new RVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.id.setText(Integer.toString(i+1));
        viewHolder.name.setText(students.get(i).name);
        viewHolder.addTime.setText(students.get(i).addTime);
    }

    @Override
    public int getItemCount()
    {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView id;
        TextView name;
        TextView addTime;

        public ViewHolder(View itemView)
        {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name);
            addTime = itemView.findViewById(R.id.tv_addTime);
        }
    }
}
