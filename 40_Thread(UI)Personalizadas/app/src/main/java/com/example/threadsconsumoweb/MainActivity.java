package com.example.threadsconsumoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     private Button buttonIni;
     private int numero;//Class anonima
     private Handler handler = new Handler();//Obj evia codigos para serem executados na Thread(que lhe criou), ou de uma Thread pra outra
     private boolean pararExec = false;//Botao parar Thread


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
     
          buttonIni = findViewById(R.id.buttonIniciar);

     }

     public void iniciarThread(View view){

          //MyThread myThread = new MyThread();
         // myThread.start();

         MyRunnable myRunnable = new MyRunnable();
         new Thread(myRunnable).start();

          //Criando processo na Therad principal(UI)
//          for (int i = 0; i <= 15; i++){
//               Log.d("Thread", "Contador:" + i );
//               try {
//                    Thread.sleep(1000);//Enviando tarefa pra thread principal(UI)
//               } catch (InterruptedException e) {
//                    e.printStackTrace();
//               }
//          }
     }

     public void pararThread(View view){
          pararExec = true;
     }

     //Uma forma de criar minha Thread
     public class MyThread extends Thread{//Criando uma thread secundaria - inner class

          //private Handler handler = new Handler();//Enviara tarefas para essa Thread, pois ele foi instanciado nela

          @Override//Para criar a Thread temos que sobrescrever o metodo run();
          public void run() {
               //super.run();
               for (int i = 0; i <= 15; i++){
                    Log.d("Thread", "Contador:" + i );

                    try {
                         Thread.sleep(1000);//Como sobrescrevemos o metodo run, esse comando vai para a thread de (MyThread)
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          }
     }

     //Outra forma de criar minha thread - Implementando a interface diretamente, pq (Thread implements Runnable)
     public class MyRunnable implements Runnable{

          @Override
          public void run() {//E sempre sobrescrevar o metodo run();
               for (int i = 0; i <= 15; i++){
                    Log.d("Thread", "Contador:" + i );

                    numero = i;//Nao entra na classe anonima
                    //Passando tarefas para thread UI partindo de outra Thread - Jamilton usa runOnUiThread() - nao instancia nada
//                    runOnUiThread(new Runnable() {//Atravez desse metodo outras thread passam para UI atividades para fazer na View
//                         @Override
//                         public void run() {
//                              buttonIni.setText("Contador: " + numero);
//                         }
//                    });

                    if (pararExec) {//Quando apertar o botao parar Thread
                         pararExec = false;
                         return;//Aborta a execucao do metodo
                    }

                    //Passando tarefas para thread UI partindo de outra Thread - Pelo obj Handler
                    handler.post(new Runnable() {
                         @Override
                         public void run() {
                              buttonIni.setText("Contador: " + numero);
                         }
                    });

                    //Passando tarefas para thread atual
                    try {
                         Thread.sleep(1000);//Como sobrescrevemos o metodo run, esse comando para nossa thread(MyThread)
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
               }
          }
     }
}