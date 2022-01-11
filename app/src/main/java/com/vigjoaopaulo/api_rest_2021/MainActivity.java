package com.vigjoaopaulo.api_rest_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dashboard");

    }



    public void listPersona(View view) {
        Intent intent = new Intent(MainActivity.this, ListaPersona.class);
        startActivity(intent);
    }

    public void produto(View view) {
        Intent intent = new Intent(MainActivity.this, PaginaUsuario.class);
        startActivity(intent);
    }

    public void business(View view) {
        Intent intent = new Intent(MainActivity.this, PaginaBusiness.class);
        startActivity(intent);
    }
}