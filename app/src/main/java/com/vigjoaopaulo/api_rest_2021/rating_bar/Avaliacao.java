package com.vigjoaopaulo.api_rest_2021.rating_bar;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.R;

public class Avaliacao extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView nota;
    private Button btnSubmit;
    private TextView label;

    private String[] nivel = {"Péssimo","Ruim","Moderado","Bom", "Excelente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        label =(TextView) findViewById(R.id.lblAvalie);

        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        nota = (TextView) findViewById(R.id.txtValorAvaliacao);

        //se o valor de avaliação mudar,
        //exiba o valor de avaliação atual no resultado (textview) automaticamente
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {
                nota.setText(valueOf(avaliacao));

                if(avaliacao == 1.0){
                    label.setText(nivel[0]);

                }else if(avaliacao == 2.0){
                    label.setText(nivel[1]);

                }else if(avaliacao == 3.0){
                    label.setText(nivel[2]);

                }else if(avaliacao == 4.0){
                    label.setText(nivel[3]);

                }else if(avaliacao == 5.0){
                    label.setText(nivel[4]);
                }

            }
        });
    }

    public void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //se o botão for clicado, exiba o valor de avaliação corrente.
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Avaliacao.this,
                        valueOf("Teste"+ ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();




            }
        });
    }
}