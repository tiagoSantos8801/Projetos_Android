package com.example.entendendofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

     //Classes de Acesso
     //private DatabaseReference referenceDB = FirebaseDatabase.getInstance("https://conhecendofirebase-c4a9f-default-rtdb.firebaseio.com/")
     //                                                        .getReference();//Banco
    // private FirebaseAuth usuario = FirebaseAuth.getInstance();//Autentificacao (usuario/senha)

     //getInstance() - Instancia que salva os dados
     //getReference() - Pega o no raiz do DB
     //getReference(usuarios) - o raiz agora e usuario

     Button buttonUp;
     ImageView imageUp;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

     //Aula 1- Salvando e atualisando ##############################################################
          //Banco nao relacional
          //DatabaseReference usuarios = referenceDB.child("Usuarios");
          //DatabaseReference produtos = referenceDB.child("Produtos");

          //Obj passado - Salva e Atualisa dados da msma maneira
          //No usuarios
         /* Usuario usuario = new Usuario();
          usuario.setNome("Brenda");
          usuario.setIdade(21);
          usuario.setCpf("062.272.083.02");

          //No Produtos
          Produto produto= new Produto();
          produto.setDescricao("Ihpone x");
          produto.setPreco(5.599);


          usuarios.child("002").setValue(usuario);
          produtos.child("001").setValue(produto);*/

     //Aula 2- Recuperando dados ###################################################################
         /* usuarios.addValueEventListener(new ValueEventListener() {//Ouvinte apenas em usuarios

               //DatabaseReference usuarios = referenceDB.child("Usuarios").child("001");

               //Quando ha modificacoes o ouvinte atualiza mandando o json(tempo real)
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i("FIREBASE", dataSnapshot.getValue().toString());
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
          });*/

     //Aula 3- Cadastrar e verificacao de usuario logado ###########################################

          //Criando usuario e senha - Checando se o usuario foi criado com listner
         /* usuario.createUserWithEmailAndPassword(
                  "bsbBruno@gmail.com", "Eu88970176")
                  .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                            if( task.isSuccessful() ){
                                 Log.i("CreateUser", "Sucesso ao cadastrar usuario!" );
                            }else {
                                 Log.i("CreateUser", "Erro ao cadastrar usuario!" );
                            }
                       }
                  });usuario.signOut();//Desloga usuario criado*/

          //Logando e deslogando usuario - checando com listner
          /*usuario.signInWithEmailAndPassword("bsbBruno@gmail.com", "Eu88970176")
                  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                            if( task.isSuccessful() ){
                                 Log.i("SigInUser", "Sucesso ao logar usuario!" );
                            }else {
                                 Log.i("SigInUser", "Erro ao logar usuario!" );
                            }
                       }
                  });*/

          //Verificando se o usuario esta logado - E se logado, deslogando
          /*if(usuario.getCurrentUser() != null) {
               usuario.signOut();
               Log.i("UsuarioLog","Deslogando usuario ");
          } else {
               Log.i("UsuarioLog","Usuario nao logado ");
          }*/

     //Aula 4- Identificador unico #################################################################
         /* DatabaseReference usuarios = referenceDB.child("Usuarios");

          Usuario usuarioObj = new Usuario();
          usuarioObj.setNome("Fernando");
          usuarioObj.setIdade(24);
          usuarioObj.setCpf("062.272.083.02");

          usuarios.push().setValue(usuarioObj);// push() - identificador unico
          usuario.signOut();*/
     //Aula 5- Aplicando Filtros ###################################################################

//        DatabaseReference usuarios = referenceDB.child("Usuarios");
//
//        Usuario usuarioObj = new Usuario();
//        usuarioObj.setNome("Fernando");
//        usuarioObj.setIdade(24);
//        usuarioObj.setCpf("062.272.083.02");
//
//        usuarios.push().setValue(usuarioObj);// push() - identificador unico
//        usuario.signOut();

        //Aplicando Filtros

          //DatabaseReference usuarios = referenceDB.child("Usuarios");
          //DatabaseReference usuariosPesquisa = usuarios.child("-MOknERhAlhZhNUmHoNC");

          // OU Fazer consultas com Query
          //Query usuariosPesquisa = usuarios.orderByChild("nome").equalTo("Tiago");
          //Query usuariosPesquisa = usuarios.orderByKey().limitToFirst(2);
          //Query usuariosPesquisa = usuarios.orderByKey().limitToLast(2);

          //Mais formas de filtrar Com -Query
          //Maior ou igual >=
          //Query usuariosPesquisa = usuarios.orderByChild("idade").startAt(24);//startAt(x)- Maior igual a x
          //Query usuariosPesquisa = usuarios.orderByChild("idade").endAt(24);//startAt(x)- Menor igual a x
          //Query usuariosPesquisa = usuarios.orderByChild("idade").startAt(20).endAt(25);//startAt(x)- 20<=x<=25

          //Filtrando palavras
/*          Query usuariosPesquisa = usuarios.orderByChild("nome").startAt("Fi").endAt("T" + "\uf8ff");

          //Usado para todos os casos
          usuariosPesquisa.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i("DadosFiltrados", dataSnapshot.getValue().toString());//dataSnapshot- Traz os davos do banco
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
          });

 */
               //OU recebendo como um OBJ
/*
          usuariosPesquisa.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                         //getValue(Usuario.class) - Retorna um obj desse tipo - Ja com os dados do banco
                         Usuario usuarioDadosRecebidos = dataSnapshot.getValue(Usuario.class);
                         Log.i("DadosFiltrados","Nome: " + usuarioDadosRecebidos.getNome()+
                                  " Cpf: " +usuarioDadosRecebidos.getCpf()+
                                 " Idade: "+ usuarioDadosRecebidos.getIdade());//dataSnapshot- Traz os davos do banco
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
          });
*/
     //Aula 6- Upload de imagem ####################################################################

          imageUp = findViewById(R.id.imageUp);
          buttonUp = findViewById(R.id.buttonUp);

          buttonUp.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                    //Configura imagem para ser salva em memoria
                    imageUp.setDrawingCacheEnabled(true);//definir cache de desenho ativado
                    imageUp.buildDrawingCache();//construir cache de desenho

                    //Recupera o bitMap da imagem
                    Bitmap bitmap = imageUp.getDrawingCache();//obter Cache de Desenho

                    //Comprimir o bitMap para um formato expecifico (png, jpeg)
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();//E a corrente de saida de dados(Para o firebase)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                    //Convertento o baos para pixels brutos para trafego de daos
                    byte[] dadosBrutosImage = baos.toByteArray();//No formato que o FireBase aceita

                    //Definindo nos para o Storage
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference();//Instacia o local dos arquivos
                    StorageReference imagens = storageReference.child("imagens");//Cria pasta
                    //StorageReference imagens = storageReference.child("imagens/celular.jpeg");//Cria pasta e ja colocaria arquivo

                    //Nome da imagem
                    String nomeImage = UUID.randomUUID().toString();//Nome randomico
                    StorageReference imageRef = imagens.child("89cadcc9-7e01-4d23-98ff-d0dc8ffcf2dc.jpeg");//Local de armazenamento da imagem

/*
                    //Retorna um obj que ira controlar o upload
                    UploadTask uploadTask = imageRef.putBytes(dadosBrutosImage);//OBS.:O usuario tem que estar logado para upar (regras)

                    uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                              Toast.makeText(
                                      MainActivity.this,
                                      "Falha ao Upar arquivo" + e.getMessage(),
                                      Toast.LENGTH_SHORT
                              ).show();
                         }
                    }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                              //Uri url = taskSnapshot.getDownloadUrl(); - Antigo
                              imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {//Pegando url da imagem
                                   @Override
                                   public void onComplete(@NonNull Task<Uri> task) {
                                        Uri url = task.getResult();//Pega a url em formato uri

                                        Toast.makeText(
                                                MainActivity.this,
                                                "Sucesso ao Upar arquivo" + url.toString(),
                                                Toast.LENGTH_SHORT
                                        ).show();
                                   }
                              });

                         }
                    });*/
     //Aula 7- Deletando e baixando imagem #########################################################

               //DELETANDO
                  /*  StorageReference imageRef = imagens.child("edf06aef-c857-46c5-97d1-833fc7930910.jpeg");

                    imageRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {

                              Toast.makeText(
                                      MainActivity.this,
                                      "Falha ao Deletar arquivo" + e.getMessage(),
                                      Toast.LENGTH_SHORT
                              ).show();

                         }
                    }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                         @Override
                         public void onSuccess(Void aVoid) {

                              Toast.makeText(
                                      MainActivity.this,
                                      "Sucesso ao Deletar arquivo",
                                      Toast.LENGTH_SHORT
                              ).show();

                         }
                    });*/

               //Carregar uma image do firebase dentro de uma view BAIXANDO

                    Glide.with(MainActivity.this)//Passa o contexto dessa activity
                            .using(new FirebaseImageLoader())//Informa que o carregamento sera feito pelo fireBase
                            .load(imageRef)//A imagem do dowload
                            .into(imageUp);//Destino da imagem
               }
          });

     }
}
