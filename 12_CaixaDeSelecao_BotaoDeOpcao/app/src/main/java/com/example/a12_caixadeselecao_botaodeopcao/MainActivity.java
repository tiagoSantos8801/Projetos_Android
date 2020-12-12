package com.example.a12_caixadeselecao_botaodeopcao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //CheckBox
    CheckBox checkVerde, checkBranco, checkVermelho;
    //TextView
    TextView textoResul;
    //RadioButton
    RadioButton sexoMasculino, sexoFeminino;
    //RadioGroup
    RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CheckBox - Pegando pelo id
        checkVerde    = findViewById(R.id.checkVerde);
        checkBranco   = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        //TextView - Id
        textoResul    = findViewById(R.id.textResultado);

        //RadioButton
        sexoMasculino = findViewById(R.id.radioButtonMasc);
        sexoFeminino  = findViewById(R.id.radioButtonFen);
        opcaoSexo     = findViewById(R.id.radioGroupSexo);

        radioButton();//Com ouvinte
    }

    public void radioButton(){

        /*if (sexoMasculino.isChecked()) {
            textoResul.setText("Masculino");
        } else if (sexoFeminino.isChecked()){
            textoResul.setText("Feminino");
        } else {
            textoResul.setText("");
        }*/

        //OnCheckedChangeListener() -> é uma interface!
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*O id e uma numero intero, por isso (int checkedId) retorna o id do radioButton selecionado*/
                if (checkedId == R.id.radioButtonMasc) {
                    textoResul.setText("Masculino ");
                } else if ( checkedId == R.id.radioButtonFen){
                    textoResul.setText("Feminino ");
                }
            }
        });//Vamos chamar esse metodo dentro de onCreate, pois se nao vamos ficar refem do click do botao enviar
    }

    public void checkBox(){
        String texto = "";
        if(checkVerde.isChecked()) {
            //Outra forma de se fazer
            //String corSelecionada = checkVerde.getText().toString();
            //texto = corSelecionada;
            texto = texto + "Verde selecionado - ";
        }
        if(checkBranco.isChecked()){
            texto = texto + "Branco selecionado - ";
        }
        if(checkVermelho.isChecked()){
            texto = texto + "Vermelho selecionado - ";
        }

        textoResul.setText(texto);
    }

    public void enviar(View view){
        //checkBox();
        //radioButton(); -> Sem ouvinte

    }

}