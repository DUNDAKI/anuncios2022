package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vigjoaopaulo.api_rest_2021.activitys.ListaAnuncioEmpresaActivity;
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
}