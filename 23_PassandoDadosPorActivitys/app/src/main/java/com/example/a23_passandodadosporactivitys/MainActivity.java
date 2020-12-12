package com.example.a23_passandodadosporactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     private Button buttonDados;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          buttonDados = findViewById(R.id.buttonDados);

          buttonDados.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), segunda_activity.class);

                    //Passando dados primitivos
                    intent.putExtra("nome","Tiago Santos");
                    intent.putExtra("idade",24);

                    //Passando Obj
                    Usuario usuario = new Usuario("Tiago Xavier","thiagosist8801@gmail.com","eu88019367");
                    intent.putExtra("usuario", usuario);

                    //Starta a activity selecionada
                    startActivity(intent);

               }
          });

     }
}