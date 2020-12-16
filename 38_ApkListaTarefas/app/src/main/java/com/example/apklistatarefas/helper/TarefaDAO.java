package com.example.apklistatarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.apklistatarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO{

     private SQLiteDatabase escreve;//getWritableDatabase()
     private  SQLiteDatabase le;//getReadableDatabase()

     public TarefaDAO(Context context) {

          DBHelper dbHelper = new DBHelper(context);//So existe no construtor - passa o context para o banco
          escreve = dbHelper.getWritableDatabase();//Salva no banco.
          le = dbHelper.getReadableDatabase();//Le do banco.
     }

     @Override
     public boolean salvar(Tarefa tarefa) {//Recebe e salva tarefa

          ContentValues cv = new ContentValues();
          cv.put("nome", tarefa.getNomeTarefa());//Coluna e nomeTarefa

          try {
               escreve.insert(DBHelper.TABELA_TAREFAS, null, cv);//Salva no banco
               Log.i("Info","Tarefa salva com sucesso");
          } catch (Exception e){
               Log.i("Info","Erro ao salva tarefa" + e.getMessage());
               return false;
          }
          return true;
     }

     @Override
     public boolean atualizar(Tarefa tarefa) {

          ContentValues cv = new ContentValues();
          cv.put("nome", tarefa.getNomeTarefa());

          try {
               String[] args = {tarefa.getIdTarefa().toString()};//Substituido no lugar das interrogacoes
               escreve.update(DBHelper.TABELA_TAREFAS, cv, "id = ?", args);//Atualiza no banco
               Log.i("Info","Tarefa atualizada com sucesso");
          } catch (Exception e){
               Log.i("Info","Erro ao atualizar tarefa" + e.getMessage());
               return false;
          }
          return true;
     }

     @Override
     public boolean deletar(Tarefa tarefa) {

          try {
               String[] args = {tarefa.getIdTarefa().toString()};
               escreve.delete(DBHelper.TABELA_TAREFAS, "id = ?", args);//Deletando do banco
               Log.i("Info","Tarefa deletar com sucesso");
          } catch (Exception e){
               Log.i("Info","Erro ao deletar tarefa" + e.getMessage());
               return false;
          }
          return true;
     }

     @Override
     public List<Tarefa> listar() {

          List<Tarefa> listaTarefas = new ArrayList<>();

          //Comando SQL
          String sql = "SELECT * FROM " + DBHelper.TABELA_TAREFAS + " ;";

          //Cursor indexando as colunas
          Cursor cursor = le.rawQuery(sql, null);//Seleciona colunas

          while (cursor.moveToNext()){
               Tarefa tarefa = new Tarefa();
               Long id = cursor.getLong(cursor.getColumnIndex("id"));
               String nomeTarefa = cursor.getString(cursor.getColumnIndex("nome"));

               tarefa.setIdTarefa(id);
               tarefa.setNomeTarefa(nomeTarefa);

               listaTarefas.add(tarefa);//Adciona todas as tarefas ao Array
          }
          return listaTarefas;//Retorna o array de todas as tarefas listadas
     }
}
