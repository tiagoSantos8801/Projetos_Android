package com.example.appatmconsultoria.ui.sobre;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appatmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

     public SobreFragment() {
     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
          String description = "ATM consultoria tem como missao apoiar organisaçoes" +
                               "que desejao alcancar o sucesso atravez da excelencia em gestao" +
                               "e da busca pela qualidade.";

          Element versao = new Element();
          versao.setTitle("Versao 1.0");

          View aboutPage = new AboutPage(getActivity())
                  .setImage(R.drawable.logo)
                  .setDescription(description)

                  .addGroup("Entre em conato")
                  .addEmail( "atendimento@atmconsutoria.com.br", "Envie um email")
                  .addWebsite("www.google.com","Acesse:")

                  .addGroup("Redes Sociais")
                  .addFacebook("thiagoXavier", "Face")
                  .addInstagram("thiagoXavier", "Insta")
                  .addYoutube("jamiltondamaceno","YouTube")
                  .addGitHub("jamiltondamaceno")
                  .addPlayStore("com.faceboock.katana")
                  .addItem(versao)
                  .create();

          return aboutPage;
          //return inflater.inflate(R.layout.fragment_sobre, container, false);
     }
}