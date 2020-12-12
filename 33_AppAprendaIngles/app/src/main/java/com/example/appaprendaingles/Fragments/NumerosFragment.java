package com.example.appaprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.appaprendaingles.R;

public class NumerosFragment extends Fragment implements View.OnClickListener {

     ImageButton imageButtonHum, imageButtonDois,
             imageButtonTres, imageButtonQuatro,
             imageButtonCinco, imageButtonSeis;
     MediaPlayer mediaPlayer;

     public NumerosFragment() {

     }

     public View onCreateView(LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {

          View view = inflater.inflate(R.layout.fragment_numeros, container, false);

          //Pegando da view do fragment
          imageButtonHum      = view.findViewById(R.id.imageButtonHum);
          imageButtonDois     = view.findViewById(R.id.imageButtonDois);
          imageButtonTres     = view.findViewById(R.id.imageButtonTres);
          imageButtonQuatro   = view.findViewById(R.id.imageButtonQuatro);
          imageButtonCinco    = view.findViewById(R.id.imageButtonCinco);
          imageButtonSeis     = view.findViewById(R.id.imageButtonSeis);

          //Listner
          imageButtonHum.setOnClickListener(this);
          imageButtonDois.setOnClickListener(this);
          imageButtonTres.setOnClickListener(this);
          imageButtonQuatro.setOnClickListener(this);
          imageButtonCinco.setOnClickListener(this);
          imageButtonSeis.setOnClickListener(this);

          return view;
     }

     @Override
     public void onClick(View view) {

          switch (view.getId()){
               case R.id.imageButtonHum:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.one
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonDois:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.two
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonTres:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.three
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonQuatro:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.four
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonCinco:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.five
                    );
                    tocarSom();
                    break;
               case R.id.imageButtonSeis:
                    mediaPlayer = MediaPlayer.create(
                            getActivity(),
                            R.raw.six
                    );
                    tocarSom();
                    break;
          }
     }

     public void tocarSom(){
          if (mediaPlayer != null){
               mediaPlayer.start();

               //Desocupando recursos
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