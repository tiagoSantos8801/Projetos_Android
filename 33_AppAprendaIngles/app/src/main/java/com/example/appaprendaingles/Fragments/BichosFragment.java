package com.example.appaprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.appaprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener {

     private ImageButton imageButtonCao, imageButtonGato,
                         imageButtonOvelha, imageButtonMacaco,
                         imageButtonVaca, imageButtonLeao;
     private MediaPlayer mediaPlayer;

     public BichosFragment() {

     }

     @Override
     public View onCreateView(LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState
     ) {
          View view = inflater.inflate(R.layout.fragment_bichos, container, false);

          //Como o fragmento nao é uma activity temos que pegar a view
          imageButtonCao      = view.findViewById(R.id.imageButtonCao);
          imageButtonLeao     = view.findViewById(R.id.imageButtonLeao);
          imageButtonOvelha   = view.findViewById(R.id.imageButtonOvelha);
          imageButtonMacaco   = view.findViewById(R.id.imageButtonMacaco);
          imageButtonGato     = view.findViewById(R.id.imageButtonGato);
          imageButtonVaca     = view.findViewById(R.id.imageButtonVaca);

          //Adcionando um listner - (Tratado na propria classe)
          imageButtonCao.setOnClickListener(this);
          imageButtonLeao.setOnClickListener(this);
          imageButtonOvelha.setOnClickListener(this);
          imageButtonGato.setOnClickListener(this);
          imageButtonMacaco.setOnClickListener(this);
          imageButtonVaca.setOnClickListener(this);

          return view;
     }
     //Evento de clique para toda a classe
     @Override
     public void onClick(View view) {

          switch (view.getId()){
               case R.id.imageButtonCao:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.dog
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonLeao:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.lion
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonOvelha:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.sheep
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonGato:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.cat
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonMacaco:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.monkey
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonVaca:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),//Pega contexto do activity
                            R.raw.cow
                    );
                    tocarSom();
                    break;
          }
     }

     public void tocarSom(){
          if (mediaPlayer != null){
               mediaPlayer.start();

               //Quando terminar de tocar som - desocupa os recursos da memoria
               mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                         mediaPlayer.release();
                    }
               });
          }
     }

     @Override
     public void onDestroy() {
          super.onDestroy();
          if (mediaPlayer != null){
               mediaPlayer.release();
               mediaPlayer = null;
          }
     }
}