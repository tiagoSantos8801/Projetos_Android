package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

     private Button buttonAbrir, buttonFachar;
     //Snackbar snackbar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          buttonAbrir = findViewById(R.id.buttonAbrir);
          buttonFachar = findViewById(R.id.buttonFechar);

          buttonAbrir.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                    /*snackbar = Snackbar.make(...)*/
                    Snackbar.make(
                            view,//Nao precisa dar um id na view
                            "Botão Prescionado",//Menssagem
                            Snackbar.LENGTH_INDEFINITE//Duration
                    ).setAction("Confirmar", new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                              buttonAbrir.setText("Botao Abrir Alterado");
                         }
                    }).setActionTextColor(getResources().getColor(R.color.design_default_color_error)).show();
                    //snackbar.show();
               }
          });

          /*buttonFachar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    snackbar.dismiss();//Fechar snackbar
               }
          });
          */
     }

     public void abrirSnackbar(View view){

     }
}