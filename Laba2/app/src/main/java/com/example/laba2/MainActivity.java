package com.example.laba2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsList;
    private ListAdapter listAdapter;
    private ViewPager itemsPager;
    private VPAdapter vpAdapter;
    private static boolean isPagePressed = false;
    private static int pagePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsList = findViewById(R.id.rv_list);
        itemsPager = findViewById(R.id.viewPager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        itemsList.setLayoutManager(layoutManager); //Расположение по строкам

        itemsList.setHasFixedSize(true); // Заранее знаем размер списка

        listAdapter = new ListAdapter(this);
        itemsList.setAdapter(listAdapter);

        vpAdapter = new VPAdapter(this);
        itemsPager.setAdapter(vpAdapter);

        if(isPagePressed)
        {
            itemsPager.setCurrentItem(pagePosition);
            itemsPager.setVisibility(View.VISIBLE);
            itemsList.setVisibility(View.GONE);
        }

        itemsPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float v, int i1)
            {}

            @Override
            public void onPageSelected(int i)
            {}

            @Override
            public void onPageScrollStateChanged(int i)
            {}
        });
        listAdapter.setOnClickListener(new ListAdapter.ClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                pagePosition = position;
                itemsPager.setCurrentItem(position);
                itemsList.setVisibility(View.GONE);
                itemsPager.setVisibility(View.VISIBLE);
                setTitle(ClassList.get(position).getName());
                isPagePressed = true;
            }
        });

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onBackPressed()
    {
        if(!itemsList.isShown())
        {
            itemsList.setVisibility(View.VISIBLE);
            itemsPager.setVisibility(View.GONE);
            isPagePressed = false;
        }
        else
        {
            finish();
        }
    }
}
