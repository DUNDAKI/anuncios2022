package com.vigjoaopaulo.api_rest_2021.clientAPI;

import com.vigjoaopaulo.api_rest_2021.model.Anuncios;
import com.vigjoaopaulo.api_rest_2021.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnuncioAPI {

    @GET("listar/")
    Call<List<Anuncios>> getAnuncios();
}
