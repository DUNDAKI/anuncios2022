package com.vigjoaopaulo.api_rest_2021.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vigjoaopaulo.api_rest_2021.model.CadastroAnuncioActivity;
import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.ArrayList;
import java.util.List;

public class Lista_Alcool extends ArrayAdapter<Anuncios> {

    private Context context;
    private List<Anuncios> anuncios;

    public Lista_Alcool(Context context, int resource, List<Anuncios> objects) {
        super(context, R.layout.model_anuncio, objects);
        this.context = context;
        this.anuncios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.model_anuncio, parent, false);


        TextView nota = (TextView) rowView.findViewById(R.id.txtNota);
        nota.setText(String.format("nota: %s ", anuncios.get(position).getNota()));



        return rowView;
    }
}