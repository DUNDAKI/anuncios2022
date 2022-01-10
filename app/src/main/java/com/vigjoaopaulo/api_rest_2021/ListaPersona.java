package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.vigjoaopaulo.api_rest_2021.adapters.PersonaAdapter;
import com.vigjoaopaulo.api_rest_2021.clientAPI.PersonaApi;
import com.vigjoaopaulo.api_rest_2021.connectionAPI.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Persona;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPersona extends AppCompatActivity {
    private ListView listView;
    private List<Persona> listPessoas;

    ConnectionAPI connectionAPI =  new ConnectionAPI();
    PersonaApi personaApi = connectionAPI.CreateRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_persona);
        listView = (ListView) findViewById(R.id.listView);
        listPessoas = new ArrayList<>();
        retornaLista();
    }

    public void retornaLista(){
        Call<List<Persona>> call =  personaApi.getPersonas();
        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
//                List<Persona> p = response.body();
//                for(Persona pessoa: p){
//                    pessoas.add(pessoa);
//                }


//                ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(MainActivity.this,R.layout.activity_main, p);
//                listView.setAdapter(adapter);
                listPessoas =  response.body();
                listView.setAdapter(new PersonaAdapter(ListaPersona.this, R.layout.activity_main, listPessoas));


            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Log.e("Erro", t.getMessage());
            }
        });
    }
}