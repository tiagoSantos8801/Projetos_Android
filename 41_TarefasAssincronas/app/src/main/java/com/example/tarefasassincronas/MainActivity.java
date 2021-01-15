package com.example.tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button button;
     ProgressBar progressBar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          button = findViewById(R.id.buttonInit);
          progressBar = findViewById(R.id.progressBar);

     }

     //Ao clicar no botao iniciar
     public void iniciarAsynkTask(View view){
          MyAsyncTask myAsyncTask = new MyAsyncTask();
          myAsyncTask.execute(10);//Esse metodo executa a classe da forma correta.
     }
     /*
     * 1 -> Parametro a ser passado para classe / void
     * 2 -> Tipo de valor que sera utilizado para
     *      o progresso da tarefa
     * 3 -> Retorno apos tarefa finalisada
     * */                       //doInBackground(),onProgressUpdate(),onPostExecute()
     public class MyAsyncTask extends AsyncTask<Integer, Integer, String>{//AsyncTask - para facilitar a comunicacao entre as Threads

          @Override//Fazer preparacoes
          protected void onPreExecute() {
               super.onPreExecute();
               progressBar.setVisibility(View.VISIBLE);
          }

          @Override//Execucoes pesadas
          protected String doInBackground(Integer... integers) {//Integer... integers - VarArgs, tipo um array

               int numero = integers[0];
               for (int i = 0; i <= numero; i++){
                    //progressBar.setVisibility(View.VISIBLE);//View nao execulta em contexto de Thread que nao seja UI
                    publishProgress(i);//Envia para onProgressUpdate()

                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
               return "Finalisado. ";
          }

          @Override//Progresso do doInBackground() - uma barra de progress
          protected void onProgressUpdate(Integer... values) {
               super.onProgressUpdate(values);
               progressBar.setProgress(values[0]);
          }

          @Override//Apos conclusao das intrucoes do doInBackground()
          protected void onPostExecute(String s) {
               super.onPostExecute(s);

               progressBar.setProgress(0);//Retorna para o progresso zero
               progressBar.setVisibility(View.INVISIBLE);

               Toast.makeText(MainActivity.this,
                       s, Toast.LENGTH_SHORT).show();
          }
     }
}