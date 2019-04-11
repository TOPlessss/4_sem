package com.example.lab1;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private final int size = 100000;
    ItemsList[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "OnCreate: Started");
        ListView mListView = (ListView)findViewById(R.id.listView);
        list = new ItemsList[size];
        fillArray();

        ListAdapter adapter = new MyArrayAdapter(this, R.layout.adapter_view_layout, list);
        mListView.setAdapter(adapter);
    }
    public void fillArray()
    {
        for(int i = 1; i <= size; i++)
        {
            ItemsList item = new ItemsList(i);
            list[i - 1] = item;
        }
    }
}
