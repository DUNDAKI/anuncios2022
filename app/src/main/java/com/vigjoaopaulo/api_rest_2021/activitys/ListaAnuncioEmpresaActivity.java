package com.vigjoaopaulo.api_rest_2021.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.adapters.AnuncioAdapter;
import com.vigjoaopaulo.api_rest_2021.adapters.Lista_Alcool;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioService;
import com.vigjoaopaulo.api_rest_2021.Retrofit.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaAnuncioEmpresaActivity extends AppCompatActivity {
    private ListView listView;
    private List<Anuncios> anuncios;
    private  TextView serv;
    private String[] status = {"on-line...", "of-line...","servidor indispponívél no momento"};


    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioService anuncioService = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_controle_activity);

        listView = (ListView) findViewById(R.id.listViewAnuncio);
        anuncios = new ArrayList<>();


        retornaProduto();
//        listProd();


    }

    public void getLIsta(){
        ArrayList<Anuncios> lista = new ArrayList<>();
        Anuncios a = new Anuncios(1,"Alcool Tupi", "Gasolina", 5.99, "Ivo de Genova", "111", "Ibate", "SP",4);
        lista.add(a);

        a = new Anuncios(1,"Posto Ibate", "Alcoll", 5.99, "Ivo de Genova", "111", "Ibate", "SP",2);
        lista.add(a);
        listView.setAdapter(new AnuncioAdapter(ListaAnuncioEmpresaActivity.this, R.layout.painel_controle_activity, lista));


    }


    public void retornaProduto(){
        Call<List<Anuncios>> call =  anuncioService.getAnuncios();
        call.enqueue(new Callback<List<Anuncios>>() {
            @Override
            public void onResponse(Call<List<Anuncios>> call, Response<List<Anuncios>> response) {

                anuncios =  response.body();
                if(response.isSuccessful()){

                    if(anuncios.isEmpty()){
                        Log.e("status ", "Nenhum registro encontrado!!!");
                        Toast.makeText(ListaAnuncioEmpresaActivity.this, "Nenhum registro encontrado!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        Log.e("Lista", String.valueOf(anuncios));
                        listView.setAdapter(new AnuncioAdapter(ListaAnuncioEmpresaActivity.this, R.layout.painel_controle_activity, anuncios));
                    }
//                    Log.e("status ", status[0]);
//                    Toast.makeText(ListaAnuncioEmpresaActivity.this, status[0], Toast.LENGTH_SHORT).show();

                }else{
                    setContentView(R.layout.status);
                    serv = (TextView) findViewById(R.id.txtStatus);

                    serv.setText(status[2]);
                    Log.e("status ", status[1]);
                    Toast.makeText(ListaAnuncioEmpresaActivity.this, status[2], Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<List<Anuncios>> call, Throwable t) {
                Log.e("Erro", t.getMessage());
            }
        });

    }

    public void listProd(){
        Call<List<Anuncios>> call =  anuncioService.getAlcool();
        call.enqueue(new Callback<List<Anuncios>>() {
            @Override
            public void onResponse(Call<List<Anuncios>> call, Response<List<Anuncios>> response) {

                anuncios =  response.body();
                listView.setAdapter(new Lista_Alcool(ListaAnuncioEmpresaActivity.this, R.layout.painel_controle_activity, anuncios));
                Log.e("nota", String.valueOf(anuncios));
            }

            @Override
            public void onFailure(Call<List<Anuncios>> call, Throwable t) {
                Log.e("Erro", t.getMessage());
            }
        });

    }


}