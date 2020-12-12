package com.example.a17_seekbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarProg;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarProg    = findViewById(R.id.seekBarProgresso);
        textoResultado = findViewById(R.id.textResult);

        seekBarProg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //Quando move a barra
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textoResultado.setText("Prograsso: " + progress + " / " + seekBar.getMax());
            }
            //Quando precionar o botao da barra.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //textoResultado.setText("onStartTrackingTouch");
            }
            //Quando solta o botao da barra.
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textoResultado.setText("onStopTrackingTouch");
            }
        });

    }

    public void recuperarProgresso(View view){
        textoResultado.setText("Escolhido: " + seekBarProg.getProgress());
    }
}