package com.vigjoaopaulo.api_rest_2021.connectionAPI;

import com.vigjoaopaulo.api_rest_2021.apis.Apis;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionAPI {

    Apis api = new Apis();
    public AnuncioService CreateAnuncioRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(api.getAnuncio())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnuncioService personaApi = retrofit.create(AnuncioService.class);
        return personaApi;

    }




}
