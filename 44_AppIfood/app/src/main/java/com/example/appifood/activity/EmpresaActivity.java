package com.example.appifood.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.appifood.R;
import com.example.appifood.helper.ConfiguracaoFireBase;
import com.google.firebase.auth.FirebaseAuth;

public class EmpresaActivity extends AppCompatActivity {

     private FirebaseAuth auth;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_empresa);

          //Configuracoes Toolbar
          Toolbar toolbar = findViewById(R.id.toolbar);
          toolbar.setTitle("Ifood - Empresa");
          setSupportActionBar(toolbar);//Toolbar como o suporte para essa activity

          auth = ConfiguracaoFireBase.getFirebaseAutentificacao();//Pegando acesso ao usuario

     }

     @Override//Criando o menu
     public boolean onCreateOptionsMenu(Menu menu) {

          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.menu_empresa, menu);

          return super.onCreateOptionsMenu(menu);
     }

     @Override//Opcoes selecionadas
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {

          switch (item.getItemId()){
               case R.id.menuSair:
                    deslogarUsuario();
                    break;
               case R.id.menuConfiguracoes:
                    abrirConfiguracoes();
                    break;
               case R.id.menuNovoProduto:
                    abrirNovoProduto();
                    break;
          }

          return super.onOptionsItemSelected(item);
     }

     private void abrirNovoProduto() {
          startActivity(new Intent(EmpresaActivity.this, NovoProdutoEmpresaActivity.class));
     }

     private void abrirConfiguracoes() {
          startActivity(new Intent(EmpresaActivity.this, ConfiguracoesEmpresaActivity.class));
     }

     private void deslogarUsuario() {
          try {//Tratando possivel erro ao deslogar usuario
               auth.signOut();
               startActivity(new Intent(EmpresaActivity.this, AutenticationActivity.class));
               finish();
          } catch (Exception e){
               e.printStackTrace();
          }
     }
}