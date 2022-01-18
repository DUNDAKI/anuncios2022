package com.vigjoaopaulo.api_rest_2021.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.adapters.AnuncioAdapter;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioService;
import com.vigjoaopaulo.api_rest_2021.connectionAPI.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaAnuncioEmpresaActivity extends AppCompatActivity {
    private ListView listView;
    private List<Anuncios> anuncios;


    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioService anuncioService = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_controle_activity);
        listView = (ListView) findViewById(R.id.listViewAnuncio);
        anuncios = new ArrayList<>();

        retornaProduto();
    }



    public void retornaProduto(){
        Call<List<Anuncios>> call =  anuncioService.getAnuncios();
        call.enqueue(new Callback<List<Anuncios>>() {
            @Override
            public void onResponse(Call<List<Anuncios>> call, Response<List<Anuncios>> response) {

                anuncios =  response.body();
                listView.setAdapter(new AnuncioAdapter(ListaAnuncioEmpresaActivity.this, R.layout.painel_controle_activity, anuncios));
            }

            @Override
            public void onFailure(Call<List<Anuncios>> call, Throwable t) {
                Log.e("Erro", t.getMessage());
            }
        });
    }


}