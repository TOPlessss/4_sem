package com.example.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.left, R.drawable.mid, R.drawable.right, R.drawable.mid};

        v_flip = findViewById(R.id.v_flip);


        for (int image: images)
        {
            flipperImages(image);
        }

        start();
    }

    public void start()
    {
        Thread thread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    finish();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void  flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flip.addView(imageView);
        v_flip.setFlipInterval(250);
        v_flip.setAutoStart(true);
    }
}
