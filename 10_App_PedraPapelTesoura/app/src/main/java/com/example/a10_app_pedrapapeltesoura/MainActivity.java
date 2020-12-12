package com.example.a10_app_pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcao = {"Pedra","Papel","Tesoura"};//0, 1, 2
        String escolhaApp = opcao[numero];

        switch(escolhaApp){
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ){
            textoResultado.setText("Você perdeu! :(");
        } else if(
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ){
            textoResultado.setText("Você ganhou! :)");
        }else {
            textoResultado.setText("Empatamos! ;)");
        }

        System.out.println("Opcao selecionada: " + escolhaUsuario);
        System.out.println("Opcao selecionada: " + escolhaApp);
    }
}