package com.vigjoaopaulo.api_rest_2021.clientAPI;

import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BusinessApi {

    @GET("listar/")
    Call<List<Anuncios>> getAnunciosBusiness();
}
