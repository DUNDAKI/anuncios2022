package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.vigjoaopaulo.api_rest_2021.adapters.AnuncioAdapter;
import com.vigjoaopaulo.api_rest_2021.adapters.PersonaAdapter;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioAPI;
import com.vigjoaopaulo.api_rest_2021.clientAPI.PersonaApi;
import com.vigjoaopaulo.api_rest_2021.connectionAPI.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;
import com.vigjoaopaulo.api_rest_2021.model.Persona;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaUsuario extends AppCompatActivity {
    private ListView listView;
    private List<Anuncios> anuncios;

    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioAPI anuncioAPI = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_usuario);
        listView = (ListView) findViewById(R.id.listViewAnuncio);
        anuncios = new ArrayList<>();
        retornaProduto();
    }

    public void retornaProduto(){
        Call<List<Anuncios>> call =  anuncioAPI.getAnuncios();
        call.enqueue(new Callback<List<Anuncios>>() {
            @Override
            public void onResponse(Call<List<Anuncios>> call, Response<List<Anuncios>> response) {

                anuncios =  response.body();
                listView.setAdapter(new AnuncioAdapter(PaginaUsuario.this, R.layout.pagina_usuario, anuncios));


            }

            @Override
            public void onFailure(Call<List<Anuncios>> call, Throwable t) {
                Log.e("Erro", t.getMessage());
            }
        });
    }
}