package com.vigjoaopaulo.api_rest_2021.clientAPI;

import com.vigjoaopaulo.api_rest_2021.model.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonaApi {

    @GET("listar/")
    Call<List<Persona>> getPersonas();
}
