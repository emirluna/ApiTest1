package com.example.myapplication.retrofit;

import com.example.myapplication.common.Constantes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniClient {

    private static  MiniClient instance = null;
    private MiniService miniService;
    private Retrofit retrofit;

    public MiniClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_MINI_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        miniService = retrofit.create(MiniService.class);
    }

    public static MiniClient getInstance(){
        if(instance == null){
            instance = new MiniClient();
        }
        return instance;
    }

    public MiniService getMiniService(){
        return miniService;
    }

}
