package com.vigjoaopaulo.api_rest_2021.clientAPI;

import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AnuncioService {

    @GET("listar/")
    Call<List<Anuncios>> getAnuncios();

    @GET("list-alcool/")
    Call<List<Anuncios>> getAlcool();

    @POST("add/")
    Call<Anuncios> addAnuncio(@Body Anuncios anuncios);
}
