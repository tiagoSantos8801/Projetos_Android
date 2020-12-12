package com.example.appminhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

     private SharedPreferences preferences;
     private SharedPreferences.Editor editor;
     private Context context;

     private final String NOME_ARQUIVO = "anotacao.preferencias";
     private final String CHAVE_NOME = "nome";

     //Como essa classe nao herda nada - pega-se o contexto de quem herda - (MainActivity)
     public AnotacoesPreferencias(Context contextMain) {
          context = contextMain;
          preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);//Agora conseguimos acessar as preferencias - (Só o apk)
          editor = preferences.edit();
     }

     public void salvarAnotacao(String anotacao){
          editor.putString(CHAVE_NOME, anotacao);//Pegando Chave e anotacao
          editor.commit();//Salvando
     }

     public String recuperarAnotacao(){
          return preferences.getString(CHAVE_NOME, "");//s1 Valor default caso nao encontre nada
     }
}
