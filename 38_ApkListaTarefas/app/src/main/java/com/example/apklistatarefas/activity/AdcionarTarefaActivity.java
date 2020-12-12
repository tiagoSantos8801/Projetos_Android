package com.example.apklistatarefas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.apklistatarefas.R;

import java.io.Serializable;

public class AdcionarTarefaActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_adcionar_tarefa);
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.menu_main2, menu);
          return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {

          int id = item.getItemId();
          switch (id){
               case R.id.action_settings:
                    Toast.makeText(getApplicationContext(), "Salvando...", Toast.LENGTH_SHORT).show();
                    break;
          }

          return super.onOptionsItemSelected(item);
     }
}