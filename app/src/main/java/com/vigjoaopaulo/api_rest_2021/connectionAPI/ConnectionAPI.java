package com.vigjoaopaulo.api_rest_2021.connectionAPI;

import com.vigjoaopaulo.api_rest_2021.clientAPI.PersonaApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionAPI {
    public static final String URL_001 = "http://192.168.1.102:8080/personas/";

    public PersonaApi CreateRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(URL_001)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PersonaApi personaApi = retrofit.create(PersonaApi.class);
        return personaApi;

    }


}
