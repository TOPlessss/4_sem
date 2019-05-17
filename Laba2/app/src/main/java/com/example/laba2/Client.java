package com.example.laba2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client
{
    private static Service service;

    public static Service getClient()
    {
        if(service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(Service.class);
        }
        return service;
    }
}
