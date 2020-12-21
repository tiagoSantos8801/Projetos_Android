package com.example.requisicoeshtmlretrofit.api;

import com.example.requisicoeshtmlretrofit.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {

     @GET("63021220/json/")
     Call<Cep> recupererCep();//Metodo que vai recuperar o Json desse endereco

}
