package com.example.criandoitensmenu;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          Toolbar toolbar = findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);

          FloatingActionButton fab = findViewById(R.id.fab);
          fab.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    Snackbar.make(view, "Botao precionado!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
               }
          });
     }

     //Criacao e click em botoes do menu
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.menu_main, menu);//Infla o xml
          return true;
     }

     //Tratando efeitos de click
     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();//Recupera o id do menu selecionado

          switch (id) {
               case R.id.action_settings:
                    Toast.makeText(MainActivity.this, "Settings precionado!", Toast.LENGTH_SHORT).show();
                    break;
               case R.id.action_salvar:
                    Toast.makeText(getApplicationContext(),"Salvar precionado!", Toast.LENGTH_SHORT).show();
                    break;
          }
          return super.onOptionsItemSelected(item);
     }
}