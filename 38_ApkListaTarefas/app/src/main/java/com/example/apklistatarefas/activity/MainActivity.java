package com.example.apklistatarefas.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.apklistatarefas.R;
import com.example.apklistatarefas.adapter.TarefaAdapter;
import com.example.apklistatarefas.helper.RecyclerItemClickListener;
import com.example.apklistatarefas.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private TarefaAdapter tarefaAdapter;
     private List<Tarefa> listaTrefas = new ArrayList<>();

     //main
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          //Configurando recyclerView
          recyclerView = findViewById(R.id.recyclerView);

          //Adcionar evento de click - Classe por fora que gerencia
          recyclerView.addOnItemTouchListener(
                  new RecyclerItemClickListener(
                          getApplicationContext(),
                          recyclerView,
                          new RecyclerItemClickListener.OnItemClickListener() {
                               @Override
                               public void onItemClick(View view, int position) {
                                    Toast.makeText(getApplicationContext(), "Click Curto!", Toast.LENGTH_SHORT).show();
                               }

                               @Override
                               public void onLongItemClick(View view, int position) {
                                    Toast.makeText(getApplicationContext(), "Click Longo!", Toast.LENGTH_SHORT).show();
                               }

                               @Override
                               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                               }
                          }
                  )
          );

          //Toolbar
          Toolbar toolbar = findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);

          //Fab
          FloatingActionButton fab = findViewById(R.id.fab);
          fab.setOnClickListener(new View.OnClickListener() {//Ouvinte
               @Override
               public void onClick(View view) {

                    //Carregando uma nova activity - Quando clickar no action buttom
                    Intent intent = new Intent(getApplicationContext(), AdcionarTarefaActivity.class);
                    startActivity(intent);
               }
          });
     }

     //Carrega apenas uma vez - quando inicia o app
     @Override
     protected void onStart() {
          super.onStart();
          carregarListaTarefas();
     }

     public void carregarListaTarefas(){

          //Lista de tarefas
          Tarefa tarefa1 = new Tarefa();
          tarefa1.setNomeTarefa("Ir a Academia");//Estaticamente
          listaTrefas.add(tarefa1);

          Tarefa tarefa2 = new Tarefa();
          tarefa2.setNomeTarefa("Ir ao Mercado");
          listaTrefas.add(tarefa2);

          //Configurar adapter
          tarefaAdapter = new TarefaAdapter(listaTrefas);

          //Configurar RecyclerView
          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());//Gerenciador de Layout
          recyclerView.setLayoutManager(layoutManager);//Seta gerenciador
          recyclerView.setHasFixedSize(true);//Array de tamanho fixo(performace)
          recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));//Decoracao divisoria
          recyclerView.setAdapter(tarefaAdapter);//Setando adapter configurado
          
     }

     //Criando o menu
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.menu_main, menu);
          return true;
     }

     //Eventos de click no menu
     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();//Pegado id do item de menu clicado
          switch (id){
               case R.id.action_settings://Id do menu clicado
                    Toast.makeText(getApplicationContext(), "Configurando...", Toast.LENGTH_SHORT).show();
                    break;
          }
          return super.onOptionsItemSelected(item);
     }
}