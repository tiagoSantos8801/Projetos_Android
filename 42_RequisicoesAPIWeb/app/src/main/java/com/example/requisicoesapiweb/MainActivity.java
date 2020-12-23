package com.example.requisicoesapiweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

     Button buttonRecDados;
     TextView textViewResult;
     EditText editText;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          buttonRecDados = findViewById(R.id.buttonDados);
          textViewResult = findViewById(R.id.textResult);
          editText = findViewById(R.id.textPesq);

          buttonRecDados.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                    //Validando o Cep informado
                    String cep = "";
                    try {
                         cep = editText.getText().toString();
                         if (cep == null || cep.isEmpty())
                              cep = "00000000";//A request volta com o valor erro
                    } catch (Exception e){
                         e.printStackTrace();
                    }

                    //Passando e instanciando dados para Task
                    MyTask myTask = new MyTask();
                    String urlMoeda = "https://blockchain.info/ticker";//Url da solicitacao de daos da API.
                    String urlCep = "https://viacep.com.br/ws/"+cep+"/json/";
                    myTask.execute(urlCep);//Inicialisa nossa classe passando a URL como string

               }
          });
     }

     //Inner class - MyThread
     public class MyTask extends AsyncTask<String, Void, String>{

          //Preparativos
          @Override
          protected void onPreExecute() {
               super.onPreExecute();
          }

          //Tarefa Async - MyThread
          @Override
          protected String doInBackground(String... strings) {

               String stringUrl = strings[0];//Recebendo URL
               InputStream inputStream = null;
               InputStreamReader inputStreamReader = null;
               StringBuffer buffer = null;

               try {
                    //Pega stringUrl e converte pata URL
                    URL url = new URL(stringUrl);

                    //Inicia conexao atravez de uma requisicao passada pela URL
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();//Request

                    //Pegando dados oriundos da request - Array de Bytes
                    inputStream = connection.getInputStream();

                    //Le o Array de Bytes e decodifica para caracters
                    inputStreamReader = new InputStreamReader(inputStream);

                    //Utilizado para leitura dos caracters do inputStreamReader com o readLine() - leitura linha a linha
                    BufferedReader reader = new BufferedReader(inputStreamReader);

                    String linha = "";//Recebe as linhas lidas
                    buffer = new StringBuffer();//Armazena todas as linhas lidas pelo -reader.readLine() -buffer.append(linha)

                    //Os dados presisao ser lidos linha a linha e armazenados no buff - ( linha = reader.readLine() )
                    while( (linha = reader.readLine()) != null){//Quando nao tiver mais linhas para le, ele retorna nulo e sai do while
                         buffer.append(linha);//Acumulo de linhas que vai gerar o Json grandao
                    }

               } catch (MalformedURLException e) {
                    e.printStackTrace();
               } catch (IOException e){
                    e.printStackTrace();
               }

               return buffer.toString();//De StringBuffer para String
          }

          //Resultado da Request - doInBackground();
          @Override
          protected void onPostExecute(String resultado) {
               super.onPostExecute(resultado);

               //Cep
               String  logradouro = null, cep = null,
                       complemento = null, bairro = null,
                       localidade = null, uf = null, erro = null;

               //Cotacao Bitcion
               String objValor = null, moeda = null, simbolo = null;

               //Tratando o Json
               try {
                    //CEP
                    JSONObject jsonObject = new JSONObject(resultado);
                    if (resultado.contains("erro")) {
                         textViewResult.setText("Informe um valor de 8 dígito para o cep");//Mostrando dados na View
                    }else{


                         //Informacoes do obj Json
                         logradouro = jsonObject.getString("logradouro");
                         cep = jsonObject.getString("cep");
                         complemento = jsonObject.getString("complemento");
                         bairro = jsonObject.getString("bairro");
                         localidade = jsonObject.getString("localidade");
                         uf = jsonObject.getString("uf");
                         //textViewResult.setText(resultado);

                         textViewResult.setText(logradouro+"\n"+ cep+"\n"+
                                                  complemento+"\n"+ bairro+"\n"+
                                                  localidade+"\n"+ uf
                                                  );
                    }
/**
                    //Cotacao bitcoin
                    //Um obj JSON dentro do outro BRL -> Valores
                    JSONObject jsonObject = new JSONObject(resultado);
                    objValor = jsonObject.getString("BRL");

                    JSONObject jsonObjectReal = new JSONObject(objValor);
                    moeda = jsonObjectReal.getString("last");
                    simbolo = jsonObjectReal.getString("symbol");

                    textViewResult.setText(simbolo +" "+moeda);
*/
               } catch (JSONException e){
                    e.printStackTrace();
               }
          }
     }
}