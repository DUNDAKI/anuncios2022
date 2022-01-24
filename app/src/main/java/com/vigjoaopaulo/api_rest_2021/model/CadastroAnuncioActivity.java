package com.vigjoaopaulo.api_rest_2021.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.MainActivity;
import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.activitys.ListaAnuncioEmpresaActivity;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioService;
import com.vigjoaopaulo.api_rest_2021.connectionAPI.ConnectionAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroAnuncioActivity extends AppCompatActivity {
    private ListView listView;
    private List<Anuncios> anuncios;

    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioService anuncioService = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);
        setTitle("Dashboard Empresarial");


        TextView txtID = (TextView) findViewById(R.id.txtId);
        TextView nomeEmpresa = (TextView) findViewById(R.id.txtNomeEmpresa);
        TextView nomeProduto = (TextView) findViewById(R.id.txtNomeprod);
        TextView preco = (TextView) findViewById(R.id.txtPreco);
        TextView endereco = (TextView) findViewById(R.id.txtEndereco);
        TextView numero = (TextView) findViewById(R.id.txtNumero);
        TextView cidade = (TextView) findViewById(R.id.txtCidade);
        TextView sigla = (TextView) findViewById(R.id.txtEstado);
        TextView nota = (TextView) findViewById(R.id.txtNota);


        if(txtID==null && txtID.equals("")){
            txtID.setVisibility(View.VISIBLE);
        }


        Button cadastrar = (Button) findViewById(R.id.btnCadastrar);
        Button delete = (Button) findViewById(R.id.btnDelete);

        //popular a lista
//        Bundle bundle = getIntent().getExtras();
//        String id2 = bundle.getString("id");
//        String nome = bundle.getString("nomeEmpresa");
//        String prod = bundle.getString("nomeProduto");
//        String valor = bundle.getString("preco");
//        String end = bundle.getString("endereco");
//        String num = bundle.getString("numero");
//        String city = bundle.getString("cidade");
//        String estado = bundle.getString("estado");
//        String n = bundle.getString("nota");
//
//
//
//        txtID.setText(id2);
//        nomeEmpresa.setText(nome);
//        nomeProduto.setText(prod);
//        preco.setText(valor);
//        endereco.setText(end);
//        numero.setText(num);
//        cidade.setText(city);
//        sigla.setText(estado);
//        nota.setText(n);




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
                anuncios.setNota(Integer.valueOf(nota.getText().toString()));
                addAnuncio(anuncios);

                Intent intent = new Intent(CadastroAnuncioActivity.this, ListaAnuncioEmpresaActivity.class);
                startActivity(intent);
            }
        });


    }
    public void addAnuncio(Anuncios anuncios){

        Call<Anuncios> call = anuncioService.addAnuncio(anuncios);
        call.enqueue(new Callback<Anuncios>() {
            @Override
            public void onResponse(Call<Anuncios> call, Response<Anuncios> response) {
                if(response!= null){
                    Toast.makeText(CadastroAnuncioActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Anuncios> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }


}