package com.example.laba2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsList;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsList = findViewById(R.id.rv_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        itemsList.setLayoutManager(layoutManager); //Расположение по строкам

        itemsList.setHasFixedSize(true); // Заранее знаем размер списка

        listAdapter = new ListAdapter(100, this);
        itemsList.setAdapter(listAdapter);

    }
}
