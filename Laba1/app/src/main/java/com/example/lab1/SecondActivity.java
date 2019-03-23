package com.example.lab1;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private final int size = 100000;

    ArrayList<CountList> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);
        arrFill();
        MyListAdapter adapter = new MyListAdapter(this, R.layout.adapter_view_layout, list);
        mListView.setAdapter(adapter);
    }


    public void arrFill()
    {
        for(int i = 1; i <= size; i++)
        {
            CountList count = new CountList(i);
            list.add(count);
        }
    }
}
