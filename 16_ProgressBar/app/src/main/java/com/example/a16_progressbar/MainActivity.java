package com.example.a16_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBarHorizontal,
                progressBarCircular;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular   = findViewById(R.id.progressBarCircular);
        progressBarCircular.setVisibility(View.GONE);//Visibilidade(GONE, visible, invisible)
    }

    //Onclick
    public void carregarProgressBar(View view){

        //ProgressBar Horizontal
        this.progress += 1;
        progressBarHorizontal.setProgress(this.progress);//Mostra to progresso

        //ProgressBar Circular
        if( this.progress == 0 || this.progress >= 10) {
            progressBarCircular.setVisibility(View.GONE);
        }else {
            progressBarCircular.setVisibility(View.VISIBLE);
        }
    }
}