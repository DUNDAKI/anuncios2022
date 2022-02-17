package com.vigjoaopaulo.api_rest_2021.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.MainActivity;
import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.clientAPI.AnuncioService;
import com.vigjoaopaulo.api_rest_2021.Retrofit.ConnectionAPI;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroAnuncioActivity extends AppCompatActivity {
    private List<Anuncios> a = new ArrayList<>();
    private Anuncios l = new Anuncios();

    private String selecionado;
    private String prod;
    private Spinner spinner;
    ArrayAdapter<String> adapter;


    ConnectionAPI connectionAPI =  new ConnectionAPI();
    AnuncioService anuncioService = connectionAPI.CreateAnuncioRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);
        setTitle("Dashboard Empresarial");

        TextView txtID = (TextView) findViewById(R.id.txtCadID);
        TextView nomeEmpresa = (TextView) findViewById(R.id.txtCadEmpresa);
        TextView preco = (TextView) findViewById(R.id.txtCadPreco);
        TextView endereco = (TextView) findViewById(R.id.txtCadEnd);
        TextView numero = (TextView) findViewById(R.id.txtCadNum);
        TextView cidade = (TextView) findViewById(R.id.txtCadCidade);
        TextView sigla = (TextView) findViewById(R.id.txtCadEstado);
        TextView nota = (TextView) findViewById(R.id.txtCadNota);

        Button cadastrar = (Button) findViewById(R.id.btnCadCadastrar);
        Button delete = (Button) findViewById(R.id.btnCadDelete);

        //popular a lista
        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("id");
        String nome = bundle.getString("nomeEmpresa");
        prod = bundle.getString("nomeProduto");
        String valor = bundle.getString("preco");
        String end = bundle.getString("endereco");
        String num = bundle.getString("numero");
        String city = bundle.getString("cidade");
        String estado = bundle.getString("estado");
        String n = bundle.getString("nota");

        txtID.setText(id);
        nomeEmpresa.setText(nome);
        preco.setText(valor);
        endereco.setText(end);
        numero.setText(num);
        cidade.setText(city);
        sigla.setText(estado);
        nota.setText(n);


        //INICIO SPINNER

        String[] comb = {"", "Alcool","Alcool Aditivada", "Gasolina Aditivada", "Diesel Comum", "Diesel Aditivado", "GNV4", "TESTE 01"};
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, comb);
        spinner.setAdapter(adapter);



        //SETA VALOR DO BANCO NO SPINNER
        int pos = adapter.getPosition(prod);
        spinner.setSelection(pos);






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                //SETA VALOR NO BANCO
                TextView tv = (TextView) view;
                selecionado = spinner.getSelectedItem().toString();


                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                    tv.setText("Escolha um item");
                    tv.setEnabled(false);
                }else{
                    tv.setTextColor(Color.BLUE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //FINAL SPINNER



        Log.e("id", id);
        if(id.equals("")){
            cadastrar.setText("SALVAR");
            delete.setVisibility(View.INVISIBLE);

            Log.i("id","botao salvar");
        }else{
            cadastrar.setText("MODIFICAR");
            Log.i("id","botao modificar");
        }


        Log.e("prod" , prod);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Anuncios anuncios = new Anuncios();
                anuncios.setNomeEmpresa(nomeEmpresa.getText().toString());
                anuncios.setNomeProduto(selecionado);
                anuncios.setPreco(Double.valueOf(preco.getText().toString()));
                anuncios.setEndereco(endereco.getText().toString());
                anuncios.setNumero(numero.getText().toString());
                anuncios.setCidade(cidade.getText().toString());
                anuncios.setEstado(sigla.getText().toString());
                anuncios.setNota(Integer.valueOf(nota.getText().toString()));




                if(id.equals("")){
                    addAnuncio(anuncios);
                    cadastrar.setEnabled(false);
                    Intent intent = new Intent(CadastroAnuncioActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    update(anuncios, Integer.parseInt(id));

                    Intent intent = new Intent(CadastroAnuncioActivity.this, MainActivity.class);
                    startActivity(intent);
                }
           }


        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CadastroAnuncioActivity.this);
                builder.setTitle("Registro não poderá ser recuperado...");
                builder.setMessage("Excluir publicação n°: " + id);
                builder.setIcon(R.drawable.ic_aviso);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                   }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                deleteA(Integer.parseInt(id));
                                Toast.makeText(CadastroAnuncioActivity.this, "Registro apagado", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(CadastroAnuncioActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }


    public void addAnuncio(Anuncios anuncios) {

        Call<Anuncios> call = anuncioService.addAnuncio(anuncios);
        call.enqueue(new Callback<Anuncios>() {
            @Override
            public void onResponse(Call<Anuncios> call, Response<Anuncios> response) {


               if(response.isSuccessful()){
                    Toast.makeText(CadastroAnuncioActivity.this, "Registro salvo com sucesso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CadastroAnuncioActivity.this, "Ocorreu um erro", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Anuncios> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void update(Anuncios anuncios, int id){

        Call<Anuncios> call = anuncioService.update(anuncios, id);
        call.enqueue(new Callback<Anuncios>() {
            @Override
            public void onResponse(Call<Anuncios> call, Response<Anuncios> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CadastroAnuncioActivity.this, "Atualizado com sucesso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Anuncios> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void deleteA(int id){

        Call<Anuncios> call = anuncioService.delete(id );
        call.enqueue(new Callback<Anuncios>() {
            @Override
            public void onResponse(Call<Anuncios> call, Response<Anuncios> response) {
                if(response.isSuccessful()){
//                    Toast.makeText(CadastroAnuncioActivity.this, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplication(), "Deletado com sucesso", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Anuncios> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }


}