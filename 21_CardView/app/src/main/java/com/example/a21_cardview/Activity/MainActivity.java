package com.example.a21_cardview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.a21_cardview.Adapter.Adapter;
import com.example.a21_cardview.Model.Postagem;
import com.example.a21_cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Postagem> listaPostagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerPostagens);

        //Configurando Layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //Carrega postagens - Para passar para o adapter
        carregaPostagens();

        //Configurando Adapter
        Adapter adapter = new Adapter(listaPostagens);
        recyclerView.setAdapter(adapter);
    }

    public void carregaPostagens(){

        Postagem postagem = new Postagem("Tiago Xavier", "#TBT Viagem legal", R.drawable.imagem1);
        listaPostagens.add(postagem);
        postagem = new Postagem("Cicero Sami", "#TBT De programação", R.drawable.imagem2);
        listaPostagens.add(postagem);
        postagem = new Postagem("João Marcelino", "#Partiu", R.drawable.imagem3);
        listaPostagens.add(postagem);
        postagem = new Postagem("Diego Eres", "#Pode_pá", R.drawable.imagem4);
        listaPostagens.add(postagem);

    }
}