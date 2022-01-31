package com.vigjoaopaulo.api_rest_2021.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.vigjoaopaulo.api_rest_2021.MainActivity;
import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.rating_bar.Avaliacao;

public class TelaLogin extends AppCompatActivity {
    private EditText usuario;
    private EditText senha;
    private Button cadastrar;
    private CheckBox checkBox;

    private String nome = "joao";
    private String pass = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        usuario = (EditText) findViewById(R.id.editNome);
        senha =(EditText) findViewById(R.id.editSenha);
        cadastrar = (Button) findViewById(R.id.btnLogar);
        checkBox = (CheckBox) findViewById(R.id.checkboxLogin);

        usuario.setText(nome);
        senha.setText(pass);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });

        
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isSelected()){
                    usuario.setText(nome + "teste");
//                Toast.makeText(TelaLogin.this, "cheio", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void validar(){
        String user = usuario.getText().toString();
        String passWord = senha.getText().toString();

        if(user.equals(nome)){
            if(passWord.equals(pass)){
                Toast.makeText(TelaLogin.this, "Acesso autorizado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TelaLogin.this, Avaliacao.class);
                startActivity(intent);
            }else {
                Toast.makeText(TelaLogin.this, "senha incorreta", Toast.LENGTH_SHORT).show();
            }
        }else{
            usuario.findFocus();
            Toast.makeText(TelaLogin.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
        }
    }





    public void registrar(View view) {
        Intent intent = new Intent(TelaLogin.this, FormLogin.class);
        startActivity(intent);
    }
}