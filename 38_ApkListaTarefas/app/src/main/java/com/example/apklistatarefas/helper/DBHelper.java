package com.example.apklistatarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {

     public static String NOME_DB = "DB_TAREFAS";//Nome do banco
     public static int VERSION = 1;//Versoes do App
     public static String TABELA_TAREFAS = "tarefas";//Nome da tabela


     public DBHelper(@Nullable Context context) {
          super(context, NOME_DB, null, VERSION);
     }

     //Quando se cria pela primera vez (instalacao)
     @Override
     public void onCreate(SQLiteDatabase sqLiteDatabase) {

          String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                       " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL); ";

          try {
               sqLiteDatabase.execSQL(sql);
               Log.i("Info DB", "Sucesso ao criar tabela ");
          }catch (Exception e){
               Log.i("Info DB", "Erro ao criar tabela " + e.getMessage());
          }
     }

     //Quando se atualiza o app
     @Override
     public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

          String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ; ";
//        String sql = "ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN status VARCHAR(2);";

          try {
               sqLiteDatabase.execSQL(sql);//Apagando tabela
               onCreate(sqLiteDatabase);//Criando tabela novamente
               Log.i("Info DB", "Sucesso ao atualizar App ");
          }catch (Exception e){
               Log.i("Info DB", "Erro ao atualizar App " + e.getMessage());
          }
     }
}
