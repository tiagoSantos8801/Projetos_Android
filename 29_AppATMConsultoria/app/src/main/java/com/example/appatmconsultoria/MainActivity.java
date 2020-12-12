package com.example.appatmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

     private AppBarConfiguration mAppBarConfiguration;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          //Coloca a toobar para ter o menu settings
          Toolbar toolbar = findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);


          FloatingActionButton fab = findViewById(R.id.fab);
          fab.setOnClickListener(view -> enviarEmail());

          DrawerLayout drawer = findViewById(R.id.drawer_layout);
          NavigationView navigationView = findViewById(R.id.nav_view);

          //Recebe os IDs dos fragments
          mAppBarConfiguration = new AppBarConfiguration.Builder(
                  R.id.nav_principal,
                  R.id.nav_servico,
                  R.id.nav_cliente,
                  R.id.nav_contato,
                  R.id.nav_sobre
                  )
                  .setOpenableLayout(drawer)
                  .build();//Cria

          NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
          NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
          NavigationUI.setupWithNavController(navigationView, navController);
     }

       //Removendo o settings
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {
//          // Inflate the menu; this adds items to the action bar if it is present.
//          getMenuInflater().inflate(R.menu.main, menu);
//          return true;
//     }

     public void enviarEmail(){

          String telefone = "tel:88997767854";
          String imagem = "https://images4.alphacoders.com/725/thumb-350-72548.jpg";
          String maps = "https://www.google.com.br/maps/place/R.+S%C3%A3o+Jos%C3%A9,+618+-+Centro,+Juazeiro+do+Norte+-+CE,+63010-032/@-7.2030709,-39.3220159,17z/data=!3m1!4b1!4m5!3m4!1s0x7a17f554dccc65f:0x9bcf86ac69ec311b!8m2!3d-7.2030709!4d-39.3198272";

          //Intencao de fazer uma ligacao - permicao la no manifest
          //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse(telefone) );
          //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem) );
          //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(maps) );

          //Fazendo compartilhamento de coteudo
          Intent intent = new Intent( Intent.ACTION_SEND);

          intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsutia.combr", "thiagosist8801@gmail.com"});
          intent.putExtra( Intent.EXTRA_SUBJECT, "Compartilhando conteudo");
          intent.putExtra( Intent.EXTRA_TEXT, "Menssagem automatica");

          //MIMEtypes
          //intent.setType("message/rfc822");
          //intent.setType("text/plain");
          //intent.setType("image/*");
          intent.setType("application/pdf");
          startActivity(Intent.createChooser(intent, "Compartilhar"));
     }

     @Override
     public boolean onSupportNavigateUp() {
          NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
          return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                  || super.onSupportNavigateUp();
     }
}