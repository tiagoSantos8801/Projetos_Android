package com.example.a23_passandodadosporactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class segunda_activity extends AppCompatActivity {

     private TextView textNome, textEmail, textIdade, textUsuario, textSenha;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.segunda_activity);

          //Colocando os elementos de tela nas variaveis -----
          textNome = findViewById(R.id.textNome);
          textIdade = findViewById(R.id.textIdade);
          textUsuario = findViewById(R.id.textUsuario);
          textEmail = findViewById(R.id.textEmail);
          textSenha = findViewById(R.id.textSenha);

          //Classe do tipo que o metodo (getExtras();) retorna -----
          Bundle dadosPassados = getIntent().getExtras();

          //Pegando tipos primitivos -----
          String nome = dadosPassados.getString("nome");
          int idade   = dadosPassados.getInt("idade");

          //Pegando obj
          Usuario usuario = (Usuario) dadosPassados.getSerializable("usuario");

          //Carregando informacoes na View -----

          //Primitivos
          textNome.setText(nome);
          textIdade.setText(String.valueOf(idade));//Convertendo valor

          //Objeto
          textUsuario.setText(usuario.getNome());
          textEmail.setText(usuario.getEmail());
          textSenha.setText(usuario.getSenha());
     }
}