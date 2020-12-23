package com.example.appifood.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.appifood.R;
import com.example.appifood.helper.ConfiguracaoFireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class AutenticationActivity extends AppCompatActivity {

     private EditText editTextSenha, editTextEmail;
     private Switch aSwitchAcesso , aSwitchTipoUsuario;
     private Button buttonAcessar;
     private LinearLayout lineaeLayoutTipoUsuario;

     private FirebaseAuth autentificacao;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_autentication);

          getSupportActionBar().hide();//Escondendo ActionBar

          inicializarComponentes();

          //Inicializando
          autentificacao = ConfiguracaoFireBase.getFirebaseAutentificacao();//Agora pode-se acessar metodos de autentificacao
          autentificacao.signOut();//Deslogando usuario

          //Verificar usuario logado
          verificarUsuarioLogado();

          //Pegar Tipo de acesso
          aSwitchAcesso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean isCheckd) {//boolean b - informa se o switch esta marcado
                    if (isCheckd){//Empresa
                         lineaeLayoutTipoUsuario.setVisibility(View.VISIBLE);
                    } else {//Usuario
                         lineaeLayoutTipoUsuario.setVisibility(View.GONE);
                    }
               }
          });

          buttonAcessar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                    String email = editTextEmail.getText().toString();
                    String senha = editTextSenha.getText().toString();

                    if (!email.isEmpty()){//Chacer se os campos estao vazios
                         if (!senha.isEmpty()){

                              //Verificando estado do switch
                              if (aSwitchAcesso.isChecked()){//Cadastro

                                   autentificacao.createUserWithEmailAndPassword(email, senha)//A ordem dos parametros e relevante
                                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {//Task traz o resultado de listnere
                                             if (task.isSuccessful()){//Caso tenha sucesso

                                                  Toast.makeText(AutenticationActivity.this,
                                                          "Cadastro realizado com sucesso! ",
                                                          Toast.LENGTH_SHORT).show();

                                                  abrirtelaPrincipal();//Abrir nova Activity - Finalisa atual

                                             }else{//Caso falhe

                                                  String errorExcecao = "";

                                                  try {
                                                       throw task.getException();//Lanca o erro
                                                  }catch (FirebaseAuthWeakPasswordException e){//Tratando possiveis erros
                                                       errorExcecao = "Digite uma senha mais forte!";
                                                  }catch (FirebaseAuthInvalidCredentialsException e){
                                                       errorExcecao = "Informe um email válido!";
                                                  }catch (FirebaseAuthUserCollisionException e){
                                                       errorExcecao = "Esta conta já foi cadastrada";
                                                  }catch (Exception e){//Tratando genericamete
                                                       errorExcecao = "ao cadastra usuario" + e.getMessage();
                                                  }
                                                  Toast.makeText(AutenticationActivity.this,
                                                          "Erro: " + errorExcecao,
                                                          Toast.LENGTH_SHORT).show();//Exibindo o erro em um Toast
                                             }
                                        }
                                   });
                              } else {//Logar

                                   autentificacao.signInWithEmailAndPassword(email, senha)
                                   .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                             if (task.isSuccessful()){

                                                  Toast.makeText(AutenticationActivity.this,
                                                          "Logado com sucesso! ",
                                                          Toast.LENGTH_SHORT).show();

                                                  abrirtelaPrincipal();//Abrir nova Activity - Finalisa atual

                                             } else {

                                                  Toast.makeText(AutenticationActivity.this,
                                                          "Falha ao logar usuário, cheque os dados informados! ",
                                                          Toast.LENGTH_SHORT).show();

                                             }
                                        }
                                   });

                              }
                         }else {
                              Toast.makeText(AutenticationActivity.this,
                                      "Informe a senha! ", Toast.LENGTH_SHORT).show();
                         }
                    } else {
                         Toast.makeText(AutenticationActivity.this,
                                 "Informe o email! ", Toast.LENGTH_SHORT).show();
                    }
               }
          });
     }

     private void verificarUsuarioLogado(){
          FirebaseUser usuarioAtual = autentificacao.getCurrentUser();
          if (usuarioAtual != null){
               abrirtelaPrincipal();
          }
     }

     private void abrirtelaPrincipal(){
          startActivity(new Intent(
                  AutenticationActivity.this,
                  HomeActivity.class
          ));//Iniciando - HomeActivity.class
          finish();//Finalizando Activity atual
     }

     private void inicializarComponentes(){

          editTextEmail = findViewById(R.id.editCadastroEmail);
          editTextSenha = findViewById(R.id.editCadastroSenha);
          aSwitchAcesso = findViewById(R.id.switchAcesso);
          buttonAcessar = findViewById(R.id.buttonAces
                  o);
          aSwitchTipoUsuario = findViewById(R.id.switchTipoUsuario);
          lineaeLayoutTipoUsuario = findViewById(R.id.linearTipoUsuario);
     }
}