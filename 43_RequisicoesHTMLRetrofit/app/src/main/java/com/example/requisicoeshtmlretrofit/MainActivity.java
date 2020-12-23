package com.example.requisicoeshtmlretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.requisicoeshtmlretrofit.api.CEPService;
import com.example.requisicoeshtmlretrofit.api.DataService;
import com.example.requisicoeshtmlretrofit.model.Cep;
import com.example.requisicoeshtmlretrofit.model.Foto;
import com.example.requisicoeshtmlretrofit.model.Postagem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

     private Button buttonConsumo;
     private TextView textViewResult;
     private Retrofit retrofit;
     private List<Foto> listaFotos = new ArrayList<>();
     private List<Postagem> listaPostagens = new ArrayList<>();

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          //View
          buttonConsumo = findViewById(R.id.buttonConsumo);
          textViewResult = findViewById(R.id.textViewResultado);

          //Inicializando Retrofit
          retrofit = new Retrofit.Builder()
                  //.baseUrl("https://viacep.com.br/ws/")//Url base termina com a barra (/) - nesse caso
                  .baseUrl("https://jsonplaceholder.typicode.com")
                  .addConverterFactory(GsonConverterFactory.create())//Convresor == InputStream
                  .build();

          //Chamando funcao ao clicar
          buttonConsumo.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                    //recuperarCepRetrofit();//Recuperando cep
                    //recuperaListaRetrofit();//Recuperando lista de fotos
                    //salvarPostagem();
                    //atualizarDados();
                    removerPostagem();

               }
          });
     }

     public void removerPostagem(){
          DataService service = retrofit.create(DataService.class);//Instacia(anonima) e ja passa o valor por referencia
          Call<Void> call = service.deletarPostagem(2);

          call.enqueue(new Callback<Void>() {
               @Override
               public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()){
                         textViewResult.setText("Status da operacao: " + response.code());
                    }
               }

               @Override
               public void onFailure(Call<Void> call, Throwable t) {

               }
          });
     }

     public void atualizarDados(){

          //Configurando obj posttagem
          Postagem postagem = new Postagem("123",null,"Corpo postMeu");

          DataService service = retrofit.create(DataService.class);//Instacia(anonima) e ja passa o valor por referencia
          Call<Postagem> call = service.atualizarPostagemPatch(2, postagem);

          call.enqueue(new Callback<Postagem>() {
               @Override
               public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                    if (response.isSuccessful()){
                         Postagem postagemResposta = response.body();// Pegando corpo da resposta
                         textViewResult.setText(
                                 "Codigo status: " + response.code() +
                                 "\nId: " + postagemResposta.getId() +
                                 "\nUserId: " + postagemResposta.getUserId() +
                                 "\nTitulo: " + postagemResposta.getTitle() +
                                 "\nBody: " + postagemResposta.getBody()
                         );
                    }
               }

               @Override
               public void onFailure(Call<Postagem> call, Throwable t) {

               }
          });
/**
          //Configurando obj posttagem
          Postagem postagem = new Postagem("123",null,"Corpo postMeu");//Altera o titulo para nulo-@PUT

          DataService service = retrofit.create(DataService.class);//Instacia(anonima) e ja passa o valor por referencia
          Call<Postagem> call = service.atualizarPostagem(2, postagem);

          call.enqueue(new Callback<Postagem>() {
               @Override
               public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                    if (response.isSuccessful()){
                         Postagem postagemResposta = response.body();// Pegando corpo da resposta
                         textViewResult.setText(
                                 "Codigo status: " + response.code() +
                                         "\nId: " + postagemResposta.getId() +
                                         "\nUserId: " + postagemResposta.getUserId() +
                                         "\nTitulo: " + postagemResposta.getTitle() +
                                         "\nBody: " + postagemResposta.getBody()
                         );
                    }
               }
               @Override
               public void onFailure(Call<Postagem> call, Throwable t) {

               }
          });
*/
     }
     public void salvarPostagem(){

          //Configurando obj posttagem
          //Postagem postagem = new Postagem("123","Titulo post","Corpo post");

          //Salvando postagem
          DataService service = retrofit.create(DataService.class);
          Call<Postagem> call = service.salvarPostagem("123","Titulo post","Corpo post");//Para o XML

          call.enqueue(new Callback<Postagem>() {
               @Override
               public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                    if (response.isSuccessful()){
                         Postagem postagemResposta = (Postagem) response.body();
                         textViewResult.setText("Codigo: " + response.code() +
                                                       "\nId: " + postagemResposta.getId() +
                                                       "\nTitulo: " + postagemResposta.getTitle()
                         );
                    }
               }
               @Override
               public void onFailure(Call<Postagem> call, Throwable t) {

               }
          });
     }

     public void recuperaListaRetrofit(){
/**
          DataService service = retrofit.create(DataService.class);
          Call<List<Foto>> call = service.recuperarFotos();

          call.enqueue(new Callback<List<Foto>>() {
               @Override
               public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                    if (response.isSuccessful()){
                         listaFotos = response.body();//Passando a lista de fotos

                         for(int i = 0; i < listaFotos.size(); i++){
                              Foto foto = listaFotos.get(i);//Pegando cada obj foto da lista
                              Log.d("resultado","resultado: " + foto.toString());
                         }
                    }
               }

               @Override
               public void onFailure(Call<List<Foto>> call, Throwable t) {

               }
          });
*/
          DataService service = retrofit.create(DataService.class);
          Call<List<Postagem>> call = service.recuperarPosts();

          call.enqueue(new Callback<List<Postagem>>() {//Automaticamente e criada uma tarefa assincrona em uma Thread
               @Override
               public void onResponse(Call<List<Postagem>> call, Response<List<Postagem>> response) {
                    if (response.isSuccessful()) {
                         listaPostagens = response.body();//Passando a lista de fotos

                         String posts = "";
                         for (int i = 0; i < listaPostagens.size(); i++) {
                              Postagem postagem = listaPostagens.get(i);//Pegando cada obj postagem da lista
                              Log.d("resultado", "resultado: " + postagem.toString());
                              posts += postagem.toString()+"\n\n";//OU
                              //posts.concat(postagem.toString());
                         }
                         textViewResult.setText(posts);
                    }
               }
               @Override
               public void onFailure(Call<List<Postagem>> call, Throwable t) {

               }
          });
     }

     public void recuperarCepRetrofit(){

          //Passagem por referencia ?! - Conseguimaos acessar a classe anonima e usar a funcao recupererCep()
          CEPService cepService = retrofit.create(CEPService.class);//Passa a classe como parametro e ja instancia
          Call<Cep> call = cepService.recupererCep("63021220");//Passando cep com - @Path -

          call.enqueue(new Callback<Cep>() {//Automaticamente e criada uma tarefa assincrona em uma Thread
               @Override
               public void onResponse(Call<Cep> call, Response<Cep> response) {//Resposta
                    if (response.isSuccessful()){
                         Cep cep = response.body();//Pega o corpo do obj Json
                         textViewResult.setText(cep.toString());//Mostra o JSON
                    }
               }
               @Override
               public void onFailure(Call<Cep> call, Throwable t) {//Erro ao responder

               }
          });
     }
}