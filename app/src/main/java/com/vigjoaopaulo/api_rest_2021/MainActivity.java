package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vigjoaopaulo.api_rest_2021.activitys.PainelControleActivity;
import com.vigjoaopaulo.api_rest_2021.activitys.TesteActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dashboard");

    }


//
//    public void listaProdutos(View view) {
//        Intent intent = new Intent(MainActivity.this, ListaProdActivity.class);
//        startActivity(intent);
//    }

    public void produto(View view) {
        Intent intent = new Intent(MainActivity.this, PainelControleActivity.class);
        startActivity(intent);
    }

    public void business(View view) {
        Intent intent = new Intent(MainActivity.this, TesteActivity.class);
        startActivity(intent);
    }
}