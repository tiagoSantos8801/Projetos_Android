package com.example.entendendofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

     private DatabaseReference referenceDB = FirebaseDatabase.getInstance("https://conhecendofirebase-c4a9f-default-rtdb.firebaseio.com/")
                                                             .getReference();
     //getInstance() - Instancia que salva os dados
     //getReference() - Pega o no raiz do DB
     //getReference(usuarios) - o raiz agora e usuario

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

     //Aula 1- Salvando e atualisando ##########################################################
          //Banco nao relacional
          DatabaseReference usuarios = referenceDB.child("Usuarios");
          DatabaseReference produtos = referenceDB.child("Produtos");

          //Obj passado - Salva e Atualisa dados da msma maneira
          //No usuarios
          Usuario usuario = new Usuario();
          usuario.setNome("Brenda");
          usuario.setIdade(21);
          usuario.setCpf("062.272.083.02");

          //No Produtos
          Produto produto= new Produto();
          produto.setDescricao("Ihpone x");
          produto.setPreco(5.599);


          usuarios.child("002").setValue(usuario);
          produtos.child("001").setValue(produto);

     //Aula 2- Recuperando daos ##################################################################


     }
}