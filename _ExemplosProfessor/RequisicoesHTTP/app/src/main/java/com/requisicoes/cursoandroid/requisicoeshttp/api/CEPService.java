package com.requisicoes.cursoandroid.requisicoeshttp.api;

import com.requisicoes.cursoandroid.requisicoeshttp.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jamiltondamasceno
 */

public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

}
