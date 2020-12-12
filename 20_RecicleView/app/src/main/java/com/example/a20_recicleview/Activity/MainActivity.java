package com.example.a20_recicleview.Activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20_recicleview.Adapter.Adapter;
import com.example.a20_recicleview.Model.Filme;
import com.example.a20_recicleview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //Lista de FILMES
    List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //Chamando o metodo que adciona os filmes a lista.
        criarFilmes();


        //Configurar Adapter
        Adapter adapter = new Adapter(listaFilmes);//Instanciado adapter criado no package Adapter.


        //Configurar RecicleView
//--------------------------------------------------
        //Instanciando e Setando o Gerenciador de LayOut
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);//Passando o Gerenciador de LayOut para o recyclerView



        //Informando que o recyclerView vai ter um tamanho fixo - (otimizando).
        recyclerView.setHasFixedSize(true);

        //Colocando um divisor decorativo - Linha abaixo de cada View
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));


        //Setando Adapter criado
        recyclerView.setAdapter(adapter);//Pegar os dados
        //Montar a View(visualizacao) -> XML
        //E retornar para cada item do recyclerView
    }

    public void criarFilmes(){

        //Adcionando Filmes
        Filme filme = new Filme("Homem Aranha","Aventura","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Mulher Maravilha","Aventura","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Capitao America","Aventura","2015");
        this.listaFilmes.add(filme);
        filme = new Filme("Liga da justica","Aventura","2018");
        this.listaFilmes.add(filme);
        filme = new Filme("IT: A coisa","Terror","2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Pica-pal","Animacao","2016");
        this.listaFilmes.add(filme);
        filme = new Filme("A mumia","Aventura","2015");
        this.listaFilmes.add(filme);
        filme = new Filme("A bela ea fera","Animacao","2014");
        this.listaFilmes.add(filme);
        filme = new Filme("Meu malvado favorito","Animacao","2012");
        this.listaFilmes.add(filme);
        filme = new Filme("Carro 3","Animacao","2019");
        this.listaFilmes.add(filme);
        filme = new Filme("A volta dos que nao forao","Comedia","2003");
        this.listaFilmes.add(filme);
        filme = new Filme("Na pegada do manco","Porno","2008");
        this.listaFilmes.add(filme);

    }
}