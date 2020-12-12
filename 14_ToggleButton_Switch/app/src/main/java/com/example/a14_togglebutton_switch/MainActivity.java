package com.example.a14_togglebutton_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Switch switchSenha;
    ToggleButton toggleSenaha;
    CheckBox checkBoxSenha;
    TextView textViewSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSenha   = findViewById(R.id.switchSenha);
        toggleSenaha  = findViewById(R.id.toggleButtonSenha);
        checkBoxSenha = findViewById(R.id.checkBoxSenha);
        textViewSenha = findViewById(R.id.textResult);

        adcionarOuvinte();//Metodo que adciona o ouvinte == Listener
    }

    public void enviar(View view){

        if (checkBoxSenha.isChecked()) {
            textViewSenha.setText(" CheckBox ligado!");
        }else {
            textViewSenha.setText(" CheckBox desligado!");
        }
        //Igual para todos.
        /*if (toggleSenaha.isChecked()) {
            textViewSenha.setText("ToggleButton ligado!");
        }else {
            textViewSenha.setText("ToggleButton desligado!");
        }*/

        /*if (switchSenha.isChecked()) {
            textViewSenha.setText("Switch ligado!");
        }else {
            textViewSenha.setText("Switch desligado!");
        }*/
    }
    //Ouvite que retorna true ou false != do que retorna um inteiro(ID)
    public void adcionarOuvinte(){

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchSenha.isChecked()){
                    textViewSenha.setText("Ligado!1");
                } else{
                    textViewSenha.setText("Desligado!1");
                }
            }
        });

        toggleSenaha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (toggleSenaha.isChecked()) {
                    textViewSenha.setText("Ligado!2");
                }else {
                    textViewSenha.setText("Desligado!2");
                }
            }
        });

        checkBoxSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (checkBoxSenha.isChecked()) {
                    textViewSenha.setText("Ligado!3");
                }else {
                    textViewSenha.setText("Desligado!3");
                }
            }
        });
    }
}