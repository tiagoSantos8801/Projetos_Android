package com.example.a11_caixasdetexto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    //Criando os obj para
    EditText campoNome;
    TextInputEditText campoEmail;
    TextView textoResultado;
    TextView textoResultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Acessa o campo do activity_main. -> Cria tudo antes de aparecer na tela.
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);
        textoResultado2 = findViewById(R.id.textResultado2);
    }

    //Quando cliar no botao dispara essa funcao.
    public void enviar(View view){

        //Guarda o conteudo do campo na variavel.
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        //Pega o campo e coloca um novo valor(nome/email)
        textoResultado.setText(nome);
        textoResultado2.setText(email);
    }

    public void limpar(View view){

        campoNome.setText("");
        campoEmail.setText("");
    }
}
