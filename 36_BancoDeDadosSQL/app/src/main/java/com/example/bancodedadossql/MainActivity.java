package com.example.bancodedadossql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          try {//Como os dados de um DB sao sensiveis e bom, desde já, tratar possiveis erros.

               //Criando o DB
               SQLiteDatabase bancoDados = openOrCreateDatabase( "app", MODE_PRIVATE, null);

               //Criar uma tabela
               bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");

               //Apagar uma tabela
//               bancoDados.execSQL("DROP TABLE pessoas");

               //Inserir dados no banco
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana', 18)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Pedro', 50)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Bruno Santos', 27)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Brenda Jade', 23)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Cicero Sami', 39)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Tiago Santos', 25)");
//               bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Diego', 28)");

               //Update no banco
//               bancoDados.execSQL("UPDATE pessoas SET idade = 18, nome = 'Mariana Pira' WHERE id = 1");

               //Deletando um registro ou  tupla
//               bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2");//Sempre apaga toda a linha(registro)
//               bancoDados.execSQL("DELETE FROM pessoas");//Deleta apenas os campos - Nao apaga a tabela.

               //Recuperando registros - Filtros - Select
//             Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null); - 1° forma

//               String consulta = "SELECT nome, idade " + "FROM pessoas " +
//                                 "WHERE idade = 50 OR idade = 25 OR idade = 23";

               /*String consulta = "SELECT nome, idade " + "FROM pessoas " +
                                 "WHERE idade >= 20 OR idade = 18";*/

//               String consulta = "SELECT nome, idade " + "FROM pessoas " +
//                       "WHERE idade IN(18,23,25)";// IN == no

//               String consulta = "SELECT nome, idade " + "FROM pessoas " +
//                       "WHERE idade BETWEEN 30 AND 60";//BETWEEN == entre

//               String filtro = "ce";//Pesquisa do usuario
//               String consulta = "SELECT nome, idade " + "FROM pessoas " +
//                       "WHERE nome LIKE '%"+filtro+"%' ";// LIKE == como (% - complementa - antes ou depois)

//               String consulta = "SELECT nome, idade " + "FROM pessoas " +
//                       "WHERE idade >=15 ORDER BY idade DESC LIMIT 3";
//               //Ou ASC - acendente || ou nome de A-Z || LIMIT - apenas os tres primeiros

               String consulta = "SELECT * FROM pessoas";

               Cursor cursor = bancoDados.rawQuery(consulta, null);//Metodo que recupera registros

               //Indices da tabela do banco
               int indiceId    = cursor.getColumnIndex("id");// indice 0
               int indiceNome  = cursor.getColumnIndex("nome");// indice 1
               int indiceIdade = cursor.getColumnIndex("idade");// indice 2

               cursor.moveToFirst();//Iniciando cursor na posicao inicial(0)
               while (cursor != null){
                    /*
                    Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
                    Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
                    cursor.moveToNext();//Movendo para o proxomo item da lista
                    */
                    String id = cursor.getString(indiceId);
                    String nome = cursor.getString(indiceNome);
                    String idade = cursor.getString(indiceIdade);

                    Log.i("RESULTADO - id ",id + " / nome: " + nome + " / idade: " + idade);
                    cursor.moveToNext();//Movendo para o proxomo item da lista
               }
          } catch (Exception e){
               e.printStackTrace();
          }

     }
}