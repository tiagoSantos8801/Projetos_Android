package com.example.executando_videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity2 extends AppCompatActivity {

     private VideoView videoView;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_player2);

          videoView = findViewById(R.id.videoView);

          //Esconde barra de status e coloca em fullScreen
          View decorView = getWindow().getDecorView();//(getWindow() - obj de tela) - (getDecorView() - obj de manipulacao de tela)
          int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;
          decorView.setSystemUiVisibility(uiOpcoes);

          //Esconder a actionbar
          getSupportActionBar().hide();

          //Executar o video
          videoView.setMediaController(new MediaController(this));//Controlador de video padrao
          videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);//Peando video dos arquivos -(web - Uri)
          videoView.start();
     }
}