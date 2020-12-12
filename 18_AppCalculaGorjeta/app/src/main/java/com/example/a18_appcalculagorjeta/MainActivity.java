package com.example.a18_appcalculagorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textProcentagem);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        seekBarGorjeta  = findViewById(R.id.seekBarPorcGorj);

        //Adcionar Listner ao SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                //Minha versao
                String valorRecuperado = editValor.getText().toString();
                if (valorRecuperado == null || valorRecuperado.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Informe o valor total da conta!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    /*Funcao que fara tod*o o calculo de fato*/
    public void calcular(){
        //Pega um Editable e passa para Double
        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")){
            /*Toast.makeText(
                    getApplicationContext(),
                    "Informe o valor total da conta!",
                    Toast.LENGTH_SHORT
            ).show();*/
        } else {

            //Coverter de String para Double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //Clcula a Gorjeta Total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total   = gorjeta + valorDigitado;

            //Exibe Gorjeta mais Total
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + Math.round(total));
        }
    }
}
/*
package com.example.a18_appcalculagorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textProcentagem);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        seekBarGorjeta  = findViewById(R.id.seekBarPorcGorj);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String valorDaConta = editValor.getText().toString();
                if (valorDaConta == null || valorDaConta.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Informe o valor da conta!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        double totConta;
       if(editValor.getText().toString().isEmpty()){
           totConta = 0;
       }else {
           totConta = Double.parseDouble(editValor.getText().toString());
       }
        double gorjeta = totConta * (porcentagem/100);
        double total   = totConta + gorjeta;

        textGorjeta.setText("R$ " + Math.round(gorjeta));
        textTotal.setText("R$ " + total);
    }
}*/