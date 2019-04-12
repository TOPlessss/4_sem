package com.example.laba2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class Splash extends AppCompatActivity
{
    ViewFlipper v_flip;
    private Service serviceAPI = Client.getClient();
    Call<ArrayList<JsonPojoClass>> call = serviceAPI.getTech();
    private QueryTask queryTask = (QueryTask) new QueryTask();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        queryTask.execute();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int images[] = {R.drawable.left, R.drawable.mid, R.drawable.right, R.drawable.mid};

        v_flip = findViewById(R.id.v_flip);


        for (int image: images)
        {
            flipperImages(image);
        }
    }

    class QueryTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {

            try
            {
                Response<ArrayList<JsonPojoClass>> response = call.execute();
                ArrayList<JsonPojoClass> arrayList = response.body();
                assert arrayList != null;
                ClassList.fill(arrayList);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
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


