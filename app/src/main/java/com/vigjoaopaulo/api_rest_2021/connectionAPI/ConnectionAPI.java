package com.vigjoaopaulo.api_rest_2021.connectionAPI;

import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioAPI;
import com.vigjoaopaulo.api_rest_2021.clientAPI.BusinessApi;
import com.vigjoaopaulo.api_rest_2021.clientAPI.PersonaApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionAPI {
    public static final String URL_001 = "http://192.168.1.102:8080/personas/";
    public static final String API_ANUNCIO = "http://192.168.1.102:8080/anuncio/";

    public PersonaApi CreateRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(URL_001)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaApi personaApi = retrofit.create(PersonaApi.class);
        return personaApi;

    }

    public AnuncioAPI CreateAnuncioRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API_ANUNCIO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnuncioAPI personaApi = retrofit.create(AnuncioAPI.class);
        return personaApi;

    }

    public BusinessApi CreateBusinessRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API_ANUNCIO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BusinessApi businessApi = retrofit.create(BusinessApi.class);
        return  businessApi;


    }


}
