package com.vigjoaopaulo.api_rest_2021.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vigjoaopaulo.api_rest_2021.activitys.CadastroAnuncioActivity;
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

        TextView id = (TextView) rowView.findViewById(R.id.txtIdM);
        TextView nomeEmpresa = (TextView) rowView.findViewById(R.id.txtNomeEmpresaM);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.txtNomeprodM);
        TextView preco = (TextView) rowView.findViewById(R.id.txtPrecoM);
        TextView endereco = (TextView) rowView.findViewById(R.id.txtEnderecoM);
        TextView numero = (TextView) rowView.findViewById(R.id.txtNumeroM);
        TextView cidade = (TextView) rowView.findViewById(R.id.txtCidadeM);
        TextView estado = (TextView) rowView.findViewById(R.id.txtEstadoM);
        TextView nota = (TextView) rowView.findViewById(R.id.txtNota);
        TextView status = (TextView) rowView.findViewById(R.id.txtStatus);
        Button btnAvalia = (Button) rowView.findViewById(R.id.btnSubmit);
        RatingBar  ratingBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        ratingBar.setIsIndicator(true);


        btnAvalia.setVisibility(View.INVISIBLE);
        id.setText( String.format("N° da publicação: %s " , anuncios.get(position).getId()));
        nomeEmpresa.setText(String.format("Nome da empresa: %s ", anuncios.get(position).getNomeEmpresa()));
        nomeProduto.setText(String.format("Produto: %s ", anuncios.get(position).getNomeProduto()));
        preco.setText(String.format("Preço: %s ", anuncios.get(position).getPreco()));
        endereco.setText(String.format("Endereço: %s ", anuncios.get(position).getEndereco()));
        numero.setText(String.format("N°: %s ", anuncios.get(position).getNumero()));
        cidade.setText(String.format("Cidade: %s ", anuncios.get(position).getCidade()));
        estado.setText(String.format("Estado: %s ", anuncios.get(position).getEstado()));
        nota.setText(String.format("nota: %s ", anuncios.get(position).getNota()));
        ratingBar.setRating(Float.parseFloat(anuncios.get(position).getNota().toString()));


        if(id==null && id.equals("")){
            id.setVisibility(View.VISIBLE);
        }



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CadastroAnuncioActivity.class);
                intent.putExtra("id", String.valueOf(anuncios.get(position).getId()));
                intent.putExtra("nomeEmpresa", String.valueOf(anuncios.get(position).getNomeEmpresa()));
                intent.putExtra("nomeProduto", String.valueOf(anuncios.get(position).getNomeProduto()));
                intent.putExtra("preco", String.valueOf(anuncios.get(position).getPreco()));
                intent.putExtra("endereco", String.valueOf(anuncios.get(position).getEndereco()));
                intent.putExtra("numero", String.valueOf(anuncios.get(position).getNumero()));
                intent.putExtra("cidade", String.valueOf(anuncios.get(position).getCidade()));
                intent.putExtra("estado", String.valueOf(anuncios.get(position).getEstado()));
                intent.putExtra("nota", String.valueOf(anuncios.get(position).getNota()));

                context.startActivity(intent);
            }
        });


        if(position % 2 == 0){
            rowView.setBackgroundColor(Color.red(android.R.color.holo_purple));
        }else{
            rowView.setBackgroundColor(Color.YELLOW);
        }
        return rowView;
    }
}