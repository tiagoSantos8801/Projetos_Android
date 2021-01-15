package com.example.threadsconsumoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     private Button buttonIni;
     private int numero;//Class anonima (new Runnable)

     //Obj evia codigos para serem executados na Thread(que lhe instanciou, UIThread),
     // ou de uma Thread pra outra -Manda para UIThread pq foi criado em AppCompatActivity
     private Handler handler = new Handler();

     private boolean pararExec = false;//Botao parar Thread


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
     
          buttonIni = findViewById(R.id.buttonIniciar);
     }

     public void iniciarThread(View view){//Chamado pela View

          /**Chamando thread (extends Thread) que implements Runnable*/
//          MyThread myThread = new MyThread();
//          myThread.start();

          /**Chamando thread (implements Runnable)*/
          MyRunnable myRunnable = new MyRunnable();
          new Thread(myRunnable).start();

          /**Criando processo na Therad principal(UI)*/
//          for (int i = 0; i <= 15; i++){
//               Log.d("Thread", "Contador:" + i );
//               try {
//                    Thread.sleep(1000);//Enviando tarefa pra thread principal(UI)
//               } catch (InterruptedException e) {
//                    e.printStackTrace();
//               }
//          }
     }

     /**Parando thread*/
     public void pararThread(View view){
          pararExec = true;
     }

     /**Uma forma de criar minha Thread - extends de Thread/ sobrescre o metodo run()/ joga em run() o que sera executado/ tratanco com try:cath
      * Mas Thread implements Runnable - Mais direta*/
     public class MyThread extends Thread{//Criando uma thread secundaria

          //private Handler handler = new Handler();//Enviara tarefas para essa Thread, pois ele foi instanciado nela

          @Override//Para criar a Thread temos que sobrescrever o metodo run();
          public void run() {//Envia tarefas para essa tread, ja que foi sobreescrito aqui
               //super.run();
               for (int i = 0; i <= 15; i++){

                    if (pararExec == false)//Parar Thread
                         Log.d("Thread", "Contador:" + i );

                    try {
                         Thread.sleep(1000);//Thread MyThread
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          }
     }

     /**Outra forma de criar minha thread - implements de Runnable/ sobrescre o metodo run()/ joga em run() o que sera executado/ tratando com try:cath
      *Implementando a interface diretamente, pq classes que extends de Thread -  (Thread implements Runnable).
      * Arrudeio maior, pois tem que instanciar Tread, mas consegue separar o executavel da thread em si*/
     public class MyRunnable implements Runnable{//Criando uma thread secundaria - inner class

          @Override
          public void run() {//E sempre sobrescrevar o metodo run();
               for (int i = 0; i <= 15; i++){
                    Log.d("Thread", "Contador:" + i );
                    numero = i;//Para a classe anonia poder acessar - Global

                    /**1° - Atravez desse metodo outras Threads passam para UI atividades para fazer na View (Fila de exec) - Jamilton usa esse modo*/
//                   runOnUiThread(new Runnable() {//Instancia a interface e cria a cllasse anonima
//                         @Override
//                         public void run() {
//                              buttonIni.setText("Contador: " + numero);//So a UITread acessa a View
//                         }
//                    });

                    /**2° - Passando tarefas para UIthread partindo de outra Thread - Pelo obj Handler - Pq ele foi instanciado em AppCompatActivity*/
                    handler.post(new Runnable() {//Instancia a interface e cria a cllasse anonima
                         @Override
                         public void run() {
                              buttonIni.setText("Contador: " + numero);//So a UITread acessa a View
                         }
                    });

                    /**Parar execucao do app */
                    if (pararExec) {//Quando apertar o botao parar Thread
                         pararExec = false;
                         return;//Aborta a execucao do metodo
                    }

                    /**Passando tarefas para thread atual*/
                    try {
                         Thread.sleep(1000);//MyRunnable
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          }
     }
}