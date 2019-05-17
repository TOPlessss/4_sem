package com.example.lab3;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class ListActivity extends AppCompatActivity
{
    mDatabase database;
    RecyclerView recyclerView;
    RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        database = Room.databaseBuilder(this, mDatabase.class, "databaseST")
                .allowMainThreadQueries()
                .build();

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Log.d("your mom gay", Integer.toString(database.studentDao().getAll().size()));

        rvAdapter = new RVAdapter(database.studentDao().getAll());
        recyclerView.setAdapter(rvAdapter);
    }
}
