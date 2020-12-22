package com.example.requisicoeshtmlretrofit.api;

import com.example.requisicoeshtmlretrofit.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

     @GET("{cep}/json/")    //Informa que sao o mesmo cep(@Path())
     Call<Cep> recupererCep(@Path("cep") String cep);//Metodo que vai recuperar o Json desse endereco

}
