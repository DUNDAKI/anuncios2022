package com.vigjoaopaulo.api_rest_2021.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.List;

public class AnuncioAdapter  extends ArrayAdapter<Anuncios> {

    private Context context;
    private List<Anuncios> anuncios;



    public AnuncioAdapter(Context context, int resource, List<Anuncios> objects) {
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

        TextView id = (TextView) rowView.findViewById(R.id.ID);
        TextView nomeEmpresa = (TextView) rowView.findViewById(R.id.txtNomeEmpresa);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.txtNomeprod);
        TextView preco = (TextView) rowView.findViewById(R.id.txtPreco);
        TextView endereco = (TextView) rowView.findViewById(R.id.txtEndereco);
        TextView numero = (TextView) rowView.findViewById(R.id.txtNumero);

        id.setText(String.format("ID:%s ", anuncios.get(position).getId()));
        nomeEmpresa.setText(String.format("ID:%s ", anuncios.get(position).getNomeEmpresa()));
        nomeProduto.setText(String.format("ID:%s ", anuncios.get(position).getNomeProduto()));
        preco.setText(String.format("ID:%s ", anuncios.get(position).getPreco()));
        endereco.setText(String.format("ID:%s ", anuncios.get(position).getEndereco()));
        numero.setText(String.format("ID:%s ", anuncios.get(position).getNumero()));


        if(position % 2 == 0){
            rowView.setBackgroundColor(Color.CYAN);
        }else{
            rowView.setBackgroundColor(Color.RED);
        }
        return rowView;
    }
}