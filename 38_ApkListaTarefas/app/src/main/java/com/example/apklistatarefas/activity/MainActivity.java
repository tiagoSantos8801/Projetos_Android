package com.example.apklistatarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.apklistatarefas.R;
import com.example.apklistatarefas.adapter.TarefaAdapter;
import com.example.apklistatarefas.helper.DBHelper;
import com.example.apklistatarefas.helper.RecyclerItemClickListener;
import com.example.apklistatarefas.helper.TarefaDAO;
import com.example.apklistatarefas.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
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
     private Tarefa tarefaSelecionada;

     //main
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          //Configurando recyclerView
          recyclerView = findViewById(R.id.recyclerView);

          //Configurando Banco de dados
//          DBHelper db = new DBHelper(getApplicationContext());
//
//          ContentValues cv = new ContentValues();//Classe que passa arrais de inf para o banco
//          cv.put("nome", "Tarefa informada");//Chave - Valor
//
//          db.getWritableDatabase().insert(DBHelper.TABELA_TAREFAS, null, cv);//Inserindo dados no banco

          //Adcionar evento de click - Classe por fora que gerencia
          recyclerView.addOnItemTouchListener(
                  new RecyclerItemClickListener(
                          getApplicationContext(),
                          recyclerView,
                          new RecyclerItemClickListener.OnItemClickListener() {
                               @Override
                               public void onItemClick(View view, int position) {

                                    //Recuperar tarefa selecionada para edeicao
                                    Tarefa tarefaSelecionada = listaTrefas.get(position);

                                    //Enviar tarefa para AdcionarTarefaActivity
                                    Intent intent = new Intent(MainActivity.this, AdcionarTarefaActivity.class);
                                    intent.putExtra("tarefaSelecionada",tarefaSelecionada);//Passa a tarefa para AdcionarTarefaActivity
                                    startActivity(intent);

                               }

                               @Override
                               public void onLongItemClick(View view, int position) {

                                    //Recuperar tarefa que se deseja deletar
                                   tarefaSelecionada = listaTrefas.get(position);

                                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                                    //Configurando titulo e menssagem
                                    dialog.setTitle("Confirmar exclusao ");
                                    dialog.setMessage("Deseja escluir a tarefa: " + tarefaSelecionada.getNomeTarefa() + " ? ");

                                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialogInterface, int i) {

                                              //Recarregando lista - Nao mostrar tarefas apagadas

                                             TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                             if (tarefaDAO.deletar(tarefaSelecionada)){
                                                  carregarListaTarefas();
                                                  Toast.makeText(getApplicationContext(),
                                                          "Sucesso ao excluir tarefa.  ",
                                                          Toast.LENGTH_SHORT).show();
                                             } else {
                                                  Toast.makeText(getApplicationContext(),
                                                          "Erro ao excluir tarefa.  ",
                                                          Toast.LENGTH_SHORT).show();
                                             }

                                         }
                                    });

                                    dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialogInterface, int i) {

                                         }
                                    });

                                    //Exibe dialog
                                    dialog.create();
                                    dialog.show();
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

     //Carrega toda vez que a activity e reiniciada
     @Override
     protected void onStart() {
          super.onStart();
          carregarListaTarefas();//Carrega o arrayList
     }

     public void carregarListaTarefas(){

          //Lista de tarefas
          TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
          listaTrefas = tarefaDAO.listar();//Listando tarefas

          //Configurar adapter
          tarefaAdapter = new TarefaAdapter(listaTrefas);//Recebe tarefas

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