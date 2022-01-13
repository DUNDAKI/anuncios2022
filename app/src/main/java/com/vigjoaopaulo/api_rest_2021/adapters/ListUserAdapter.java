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

public class ListUserAdapter extends ArrayAdapter<Anuncios> {

    private Context context;
    private List<Anuncios> anuncios;



    public ListUserAdapter(Context context, int resource, List<Anuncios> objects) {
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

        TextView id = (TextView) rowView.findViewById(R.id.txtIdM);
        TextView nomeEmpresa = (TextView) rowView.findViewById(R.id.txtNomeEmpresaM);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.txtNomeprodM);
        TextView preco = (TextView) rowView.findViewById(R.id.txtPrecoM);
        TextView endereco = (TextView) rowView.findViewById(R.id.txtEnderecoM);
        TextView numero = (TextView) rowView.findViewById(R.id.txtNumeroM);
        TextView cidade = (TextView) rowView.findViewById(R.id.txtCidadeM);
        TextView estado = (TextView) rowView.findViewById(R.id.txtEstadoM);

        id.setText( String.format("N° da publicação: %s " , anuncios.get(position).getId()));
        nomeEmpresa.setText(String.format("Nome da empresa: %s ", anuncios.get(position).getNomeEmpresa()));
        nomeProduto.setText(String.format("Produto: %s ", anuncios.get(position).getNomeProduto()));
        preco.setText(String.format("Preço: %s ", anuncios.get(position).getPreco()));
        endereco.setText(String.format("Endereço: %s ", anuncios.get(position).getEndereco()));
        numero.setText(String.format("N°: %s ", anuncios.get(position).getNumero()));
        cidade.setText(String.format("Cidade: %s ", anuncios.get(position).getCidade()));
        estado.setText(String.format("Estado: %s ", anuncios.get(position).getEstado()));


        if(position % 2 == 0){
            rowView.setBackgroundColor(Color.CYAN);
        }else{
            rowView.setBackgroundColor(Color.YELLOW);
        }
        return rowView;
    }
}