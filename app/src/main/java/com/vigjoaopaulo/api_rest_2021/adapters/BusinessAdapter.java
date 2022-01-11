package com.vigjoaopaulo.api_rest_2021.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.model.Anuncios;

import java.util.List;

public class BusinessAdapter extends ArrayAdapter<Anuncios> {

    private Context context;
    private List<Anuncios> anuncios;



    public BusinessAdapter(Context context, int resource, List<Anuncios> objects) {
        super(context, R.layout.model_business, objects);
        this.context = context;
        this.anuncios = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.model_business, parent, false);

        TextView id = (TextView) rowView.findViewById(R.id.ID);
        TextView nomeEmpresa = (TextView) rowView.findViewById(R.id.txtNomeEmpresa);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.txtNomeprod);
        TextView preco = (TextView) rowView.findViewById(R.id.txtPreco);
        TextView endereco = (TextView) rowView.findViewById(R.id.txtEndereco);
        TextView numero = (TextView) rowView.findViewById(R.id.txtNumero);
        TextView cidade = (TextView) rowView.findViewById(R.id.txtCidade);
        TextView sigla = (TextView) rowView.findViewById(R.id.txtSigla);


        id.setText( String.format("N° DA POSTAGEM: %s " , anuncios.get(position).getId()));
        nomeEmpresa.setText(String.format("NOME DA EMPRESA: %s ", anuncios.get(position).getNomeEmpresa()));
        nomeProduto.setText(String.format("NOME DO PRODUTO: %s ", anuncios.get(position).getNomeProduto()));
        preco.setText(String.format("PREÇO: %s ", anuncios.get(position).getPreco()));
        endereco.setText(String.format("ENDEREÇO: %s ", anuncios.get(position).getEndereco()));
        numero.setText(String.format("NÚMERO: %s ", anuncios.get(position).getNumero()));



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id.setText( String.format("Rowview: %s " , anuncios.get(position).getId()));
                nomeEmpresa.setText(String.format("NOME DA EMPRESA: %s ", anuncios.get(position).getNomeEmpresa()));
                nomeProduto.setText(String.format("NOME DO PRODUTO: %s ", anuncios.get(position).getNomeProduto()));
                preco.setText(String.format("PREÇO: %s ", anuncios.get(position).getPreco()));
                endereco.setText(String.format("ENDEREÇO: %s ", anuncios.get(position).getEndereco()));
                numero.setText(String.format("NÚMERO: %s ", anuncios.get(position).getNumero()));

            }
        });


        if(position % 2 == 0){
            rowView.setBackgroundColor(Color.CYAN);
        }else{
            rowView.setBackgroundColor(Color.RED);
        }
        return rowView;
    }
}