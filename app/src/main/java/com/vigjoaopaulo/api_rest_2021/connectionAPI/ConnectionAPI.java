package com.vigjoaopaulo.api_rest_2021.connectionAPI;

import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionAPI {
    public static final String URL_001 = "http://192.168.1.102:8080/personas/";
    public static final String API_ANUNCIO = "http://192.168.1.102:8080/anuncio/";



    public AnuncioAPI CreateAnuncioRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API_ANUNCIO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnuncioAPI personaApi = retrofit.create(AnuncioAPI.class);
        return personaApi;

    }




}
