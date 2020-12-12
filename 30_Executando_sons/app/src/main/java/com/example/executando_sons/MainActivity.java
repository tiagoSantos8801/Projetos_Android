package com.example.executando_sons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

     private MediaPlayer mediaPlayer;
     private SeekBar seekVol;
     private AudioManager audioManager;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musica);

          //Aumenta ou diminui volume
          inicialisarSeekBar();
     }

     private void inicialisarSeekBar(){

          //Acessando a classe view e pegando componemte por id
          seekVol = findViewById(R.id.seekVol);

          //Configurando audio manager - (Descobrir - volume atual - vol maximo)
          audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

          //Recuprrar - volume maximo - volume atual
          int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
          int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

          //Configurar volume maximo na SeekBar
          seekVol.setMax(volumeMaximo);

          //Configurar progresso atual na SeekBar
          seekVol.setProgress(volumeAtual);

          seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

               //Quando move
               @Override
               public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
               }

               //Quando toca
               @Override
               public void onStartTrackingTouch(SeekBar seekBar) {

               }

               //Quando solta
               @Override
               public void onStopTrackingTouch(SeekBar seekBar) {

               }
          });
     }

     public void executaSom(View view){
          if(mediaPlayer != null){
               mediaPlayer.start();
          }
     }

     public void pausarmusica(View view){
          if (mediaPlayer.isPlaying())
               mediaPlayer.pause();
     }

     public void pararMusica(View view){
          if (mediaPlayer.isPlaying()){
               mediaPlayer.stop();//Ele remove a referencia de musica criada acima
               mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musica);
          }
     }

     //Metodos do ciclo da activity

     @Override
     protected void onStop() {
          super.onStop();
          if (mediaPlayer.isPlaying())
               mediaPlayer.pause();
     }

     @Override
     protected void onDestroy() {
          super.onDestroy();
          if (mediaPlayer != null && mediaPlayer.isPlaying()){
               mediaPlayer.stop();
               mediaPlayer.release();//libera recursos de midia que estajao sendo executados com a (classe mediaPlayer)
          }
     }
}