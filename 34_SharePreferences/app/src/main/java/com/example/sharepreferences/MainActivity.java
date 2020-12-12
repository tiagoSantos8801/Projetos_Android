package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private EditText editTextNome;
     private TextView textResult;
     private Button buttonSalvar;
     private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          editTextNome   = findViewById(R.id.editTextNome);
          textResult     = findViewById(R.id.textViewResultado);
          buttonSalvar   = findViewById(R.id.buttonSalvar);

          buttonSalvar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    //Usado para salvar pequenos dados            //nome do arquivo (slavar), modo privado - so o apk acessa
                    SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor =  preferences.edit();//(edit()) - Editar o arquivo colocando valores nele

                    //Validar nome
                    if(editTextNome.getText().toString().equals("")){
                         Toast.makeText(
                                 getApplicationContext(),
                                 "Preencha o nome!!! ",
                                 Toast.LENGTH_LONG
                         ).show();
                    } else {
                         String nome = editTextNome.getText().toString();//Pega String do campo

                         editor.putString("nome", nome);//Chave - Arquivo
                         editor.commit();//Salva os dados de fato

                         textResult.setText("Olá, " + nome);
                    }

               }
          });

          //Recuperando dados salvos
          SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

          //Validar se temos o "nome" em preferencias
          if (preferences.contains("nome")){      // Chave (nome) || Valor Default ("usuário não definido")
               String nome = preferences.getString("nome", "usuário não definido ");
               textResult.setText("Olá, " + nome);
          } else {
               textResult.setText("Olá, usuario não definido.");
          }
     }
}