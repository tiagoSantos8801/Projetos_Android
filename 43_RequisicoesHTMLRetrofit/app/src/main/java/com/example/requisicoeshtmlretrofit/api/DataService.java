package com.example.requisicoeshtmlretrofit.api;

import com.example.requisicoeshtmlretrofit.model.Foto;
import com.example.requisicoeshtmlretrofit.model.Postagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {

     //Pegando dados atravez do metodo de requisicao GET ###########################################

     @GET("/photos")//Rota - Informada pela API
     Call<List<Foto>> recuperarFotos();

     @GET("/posts")
     Call<List<Postagem>> recuperarPosts();

     //Salvando dados atravez do metodo de requisicao POST #########################################

     //Serve apenas para o formato Json
     @POST("/posts")//Rota
     Call<Postagem> salvarPostagem(@Body Postagem postagem);//@Body(Define o corpo de uma requisicao) converte o obj para o formato Json

     //Formato XML
     //userId=1234&title=Título postagem&body=Corpo postagem
     @FormUrlEncoded
     @POST("/posts")
     Call<Postagem> salvarPostagem(//Passando parametros atravez de filds - Campos
             @Field("userId") String userId,//Campo/tipo/nome
             @Field("title") String title,
             @Field("body") String body
     );

     //Metodos de atualisacao PUT Atualisa tudo || PATCH Atualisa apenas o que foi discriminado#####

     /**Atualiza todo o obj */
     @PUT("/posts/{id}")
     Call<Postagem> atualizarPostagem(@Path("id") int id, @Body Postagem postagem);//@Path() - informa que os IDS sao o msmo ID.


     /**Atualiza o atrbuto(campo) especifico*/
     @PATCH("/posts/{id}")
     Call<Postagem> atualizarPostagemPatch(@Path("id") int id, @Body Postagem postagem);//@Path() - informa que os IDS sao o msmo ID.

     //Metodo de Delecao - @DELETE - Sem retorno ###################################################

     /**Deletando todo o obj*/
     @DELETE("/posts/{id}")
     Call<Void> deletarPostagem(@Path("id") int id);
}
