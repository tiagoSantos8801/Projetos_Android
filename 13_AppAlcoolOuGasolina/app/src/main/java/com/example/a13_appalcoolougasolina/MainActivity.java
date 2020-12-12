package com.example.a13_appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView            textoResultado;
    private TextInputEditText   editAlcool, editGasolina;
    private Button              botaoCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool      = findViewById(R.id.editAlcool);
        editGasolina    = findViewById(R.id.editGasolina);
        botaoCalc       = findViewById(R.id.butonCalc);
        textoResultado  = findViewById(R.id.textResult);
    }

    public void calcular(View view){

        //Recuperar valores digitados.
        String precoAlcool      = editAlcool.getText().toString();
        String precoGasolina    = editGasolina.getText().toString();

        //Validar Campos
        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        //Pega resultado de validarCampos() e calcula ou informa ERROR!
        if (camposValidados){

            //Convertendo para double.
            double valorAlcool      = Double.parseDouble(precoAlcool);
            double valorGasolina    = Double.parseDouble(precoGasolina);

            //Calculando
            double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7){
                textoResultado.setText("Melhor Gasolina!");
            } else {
                textoResultado.setText("Melhor Álcool!");
            }
        } else {
            textoResultado.setText("Preencha os campos necessários");
        }
    }

    public boolean validarCampos(String precoAlcool, String precoGasolina){

        boolean camposValidados = true;
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false;
        } else  if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}