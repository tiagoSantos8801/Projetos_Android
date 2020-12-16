package com.example.apklistatarefas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.apklistatarefas.R;
import com.example.apklistatarefas.helper.TarefaDAO;
import com.example.apklistatarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdcionarTarefaActivity extends AppCompatActivity {

     private TextInputEditText textTarefa;
     private Tarefa tarefaAtual;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_adcionar_tarefa);

          //Pegando id da nova tarefa - View
          textTarefa = findViewById(R.id.textTarefa);

          //Recuperando tarefa selecionada - Veio da classe ActivityMain
          tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

          //Configurar tarefa atual na caixa de texto
          if (tarefaAtual != null){
               textTarefa.setText(tarefaAtual.getNomeTarefa());
          }
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {

          getMenuInflater().inflate(R.menu.menu_main2, menu);
          return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {

          int id = item.getItemId();
          switch (id){
               case R.id.action_settings://Salvando tarefa informada

                    TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                    if (tarefaAtual != null){//Edicao

                         String nomeTarefa = textTarefa.getText().toString();
                         if (!nomeTarefa.isEmpty()){
                             Tarefa tarefa = new Tarefa();

                             //Colocando dados em um obj tarefa
                             tarefa.setNomeTarefa(nomeTarefa);
                             tarefa.setIdTarefa(tarefaAtual.getIdTarefa());

                             //Atualisando no banco de dados
                              if (tarefaDAO.atualizar(tarefa)){
                                   Toast.makeText(getApplicationContext(),//O context cha a activity novamente
                                           "Tarefa atualizada com sucesso. ",
                                           Toast.LENGTH_SHORT).show();
                              } else {

                                   Toast.makeText(getApplicationContext(),
                                           "Erro ao atualizar tarefa.  ",
                                           Toast.LENGTH_SHORT).show();
                              }
                         }
                    } else {//Salvando

                         String nomeTarefa = textTarefa.getText().toString();//O que foi digitado
                         if (!nomeTarefa.isEmpty()){

                              Tarefa tarefa = new Tarefa();
                              tarefa.setNomeTarefa(nomeTarefa);
                              if (tarefaDAO.salvar(tarefa)){

                                   Toast.makeText(getApplicationContext(),
                                             "Salvo com sucesso. ",
                                             Toast.LENGTH_SHORT).show();
                              }else {

                                   Toast.makeText(getApplicationContext(),
                                           "Erro ao salvar tarefa.  ",
                                           Toast.LENGTH_SHORT).show();
                              }
                         }else {
                              Log.i("Info", "Tarefa não informada");
                         }
                    }
                    break;

          }
          finish();
          return super.onOptionsItemSelected(item);
     }
}