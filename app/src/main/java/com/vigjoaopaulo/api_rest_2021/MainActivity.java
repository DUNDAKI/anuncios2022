package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vigjoaopaulo.api_rest_2021.activitys.ListaAnuncioEmpresaActivity;
import com.vigjoaopaulo.api_rest_2021.model.CadastroAnuncioActivity;
import com.vigjoaopaulo.api_rest_2021.rating_bar.Avaliacao;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dashboard");

    }



    public void listaProdutos(View view) {
        Intent intent = new Intent(MainActivity.this, Avaliacao.class);
        startActivity(intent);
    }

    public void produto(View view) {
        Intent intent = new Intent(MainActivity.this, ListaAnuncioEmpresaActivity.class);
        startActivity(intent);
    }

    public void business(View view) {

    }

    public void cadastrar(View view) {
        Intent intent = new Intent(MainActivity.this, CadastroAnuncioActivity.class);
        intent.putExtra("id","");
        intent.putExtra("nomeEmpresa","Alcool Sao Paulo");
        intent.putExtra("nomeProduto","AlcooL");
        intent.putExtra("preco","5.222");
        intent.putExtra("endereco","Ivo de genova");
        intent.putExtra("numero","111");
        intent.putExtra("cidade","IBATE");
        intent.putExtra("estado","SP");
        intent.putExtra("nota","2");
        startActivity(intent);
    }
}