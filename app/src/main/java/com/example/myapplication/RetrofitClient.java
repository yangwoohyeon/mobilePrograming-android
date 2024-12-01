package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("http://10.255.89.160:8080/");
            builder.addConverterFactory(GsonConverterFactory.create()); //new 쓰면 안됨.
            retrofit=builder.build();
        }

        return retrofit;
    }
}