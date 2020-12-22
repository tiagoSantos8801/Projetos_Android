package com.example.appifood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appifood.R;

public class AutenticationActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_autentication);

          getSupportActionBar().hide();//Escondendo ActionBar

     }
}