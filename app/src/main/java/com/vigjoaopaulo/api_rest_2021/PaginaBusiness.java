package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.adapters.AnuncioAdapter;
import com.vigjoaopaulo.api_rest_2021.adapters.BusinessAdapter;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioAPI;
import com.vigjoaopaulo.api_rest_2021.clientAPI.BusinessApi;
import com.vigjoaopaulo.api_rest_2021.connectionAPI.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaBusiness extends AppCompatActivity {
    private ListView listView;
    private List<Anuncios> anuncios;

    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioAPI anuncioAPI = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_business);
        setTitle("Dashboard Business");

        TextView id = (TextView) findViewById(R.id.ID);
        TextView nomeEmpresa = (TextView) findViewById(R.id.txtNomeEmpresa);
        TextView nomeProduto = (TextView) findViewById(R.id.txtNomeprod);
        TextView preco = (TextView) findViewById(R.id.txtPreco);
        TextView endereco = (TextView) findViewById(R.id.txtEndereco);
        TextView numero = (TextView) findViewById(R.id.txtNumero);
        TextView cidade = (TextView) findViewById(R.id.txtCidade);
        TextView sigla = (TextView) findViewById(R.id.txtSigla);

        Button cadastrar = (Button) findViewById(R.id.btnCadastrar);
        Button editar = (Button) findViewById(R.id.btnEditar);
        Button delete = (Button) findViewById(R.id.btnDelete);
        Button lista = (Button) findViewById(R.id.btnListar);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Anuncios anuncios = new Anuncios();
                anuncios.setNomeEmpresa(nomeEmpresa.getText().toString());
                anuncios.setNomeProduto(nomeProduto.getText().toString());
                anuncios.setPreco(Double.valueOf(preco.getText().toString()));
                anuncios.setEndereco(endereco.getText().toString());
                anuncios.setNumero(numero.getText().toString());
                anuncios.setCidade(cidade.getText().toString());
                anuncios.setEstado(sigla.getText().toString());
                addAnuncio(anuncios);
            }
        });


    }
    public void addAnuncio(Anuncios anuncios){
        Call<Anuncios> call = anuncioAPI.addAnuncio(anuncios);
        call.enqueue(new Callback<Anuncios>() {
            @Override
            public void onResponse(Call<Anuncios> call, Response<Anuncios> response) {
                if(response!= null){
                    Toast.makeText(PaginaBusiness.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Anuncios> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

//    public void retornaProduto(){
//        Call<List<Anuncios>> call =  businessApi.getAnunciosBusiness();
//        call.enqueue(new Callback<List<Anuncios>>() {
//            @Override
//            public void onResponse(Call<List<Anuncios>> call, Response<List<Anuncios>> response) {
//
//                anuncios =  response.body();
//                listView.setAdapter(new BusinessAdapter(PaginaBusiness.this, R.layout.pagina_business, anuncios));
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Anuncios>> call, Throwable t) {
//                Log.e("Erro", t.getMessage());
//            }
//        });
//    }


}