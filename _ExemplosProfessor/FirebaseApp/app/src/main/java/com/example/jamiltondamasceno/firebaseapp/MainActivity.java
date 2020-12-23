package com.example.jamiltondamasceno.firebaseapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    /**Recupera o obj que insere informacoes no banco*/
//    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
//    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    private ImageView imageFoto;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando id da view
        buttonUpload = findViewById(R.id.buttonUpload);
        imageFoto    = findViewById(R.id.imageFoto);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Configura para imagem ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);//Capturar imgem para memoria cache
                imageFoto.buildDrawingCache();//Constroi o desenho  da imagem na memoria cache

                //Recupera bitmap da imagem (image a ser carregada)
                Bitmap bitmap = imageFoto.getDrawingCache();//Recupera a imagem desenhada na cache

                //Comprime bitmap para um formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();//Obj que recupera o bitmap da imagem para ser convertido em qualquer formato
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos );//Comprimindo para o formato JPEG

                //converte o baos para pixel brutos em uma matriz de bytes
                // (dados da imagem)
                byte[] dadosImagem = baos.toByteArray();//Para mandar para o Firebase tem que ser em um formato array de bytes

                //Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();//Obj de insercao no banco - Storage
                StorageReference imagens = storageReference.child("imagens");//Cria pasta ou (imagens\celular.jpeg)
                final StorageReference imagemRef = imagens.child("celular.jpeg");//Arquivo dentro da pasta imagens criada
                //final StorageReference imagemRef = imagens.child(nomeArqRandomico + ".jpeg");//Arquivo dentro da pasta imagens criada

                /**Fazendo Dowload - por meio de uma bibloteca do FireBase-Storage*/
                /*
                Glide.with(MainActivity.this)
                        .using(new FirebaseImageLoader())
                        .load( imagemRef )
                        .into( imageFoto );//Joga a imagem do banco nessa imageView*/

                /**Deletando image do Storage*/
                /*  imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Erro ao deletar " + e.getMessage(),
                                Toast.LENGTH_LONG ).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,
                                "Sucesso ao deletar: " ,
                                Toast.LENGTH_LONG ).show();
                    }
                });*/

                /**NOme da imagem*/
                //String nomeArquivo = UUID.randomUUID().toString();//Nome da imagem randomico
                //StorageReference imagemRef = imagens.child("celular.jpeg");//OU
                //StorageReference imagemRef = imagens.child( nomeArquivo + ".jpeg");//nome ramdomico

                /**Fazendo Upload de imagem - SE O USUARIO ESTIVER LOGADO OU MUDAR AS REGRAS*/
                //Retorna objeto que irá controlar o upload
                //UploadTask uploadTask = imagemRef.putBytes( dadosImagem );//putBytes()-recebe o array de bytes - baos.toByteArray()

                //Se foi upado com sucesso ou nao
                /*uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this,
                                "Upload da imagem falhou: " + e.getMessage().toString(),
                                Toast.LENGTH_LONG ).show();

                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //1° - modo
                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {//Modo novo
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {

                                Uri url = task.getResult();//Recuperando URL da imagem
                                Toast.makeText(MainActivity.this,
                                        "Sucesso ao fazer upload: " + url.toString() ,
                                        Toast.LENGTH_LONG ).show();
                            }
                        });

                        //2° - modo - antigo
                        Uri url = taskSnapshot.getDownloadUrl();//Modo antigo
                        Toast.makeText(MainActivity.this,
                                "Sucesso ao fazer upload: " + url.toString() ,
                                Toast.LENGTH_LONG ).show();

                    }
                });*/

            }
        });

        //DatabaseReference usuarios = referencia.child( "usuarios" );
        //DatabaseReference usuarioPesquisa = usuarios.child("-L2LBNI8du5WSBtZqpKg");

        //Pesquisas soa feitas com Query - Como se fosse um select
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marcelo");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(3);
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(3);

        /* Maior ou igual (>=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);

        /* Menor ou igual (<=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);

        /* Entre dois valores */
        /*Query usuarioPesquisa = usuarios.orderByChild("idade")
                                        .startAt(18)
                                        .endAt(22);*/

        /** Filtrar palavras */
        /*Query usuarioPesquisa = usuarios.orderByChild("nome")
                                        .startAt("Ja")
                                        .endAt("Jo" + "\uf8ff" );

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Dados usuario: ", " nome: " + dadosUsuario.getNome() + " idade: " + dadosUsuario.getIdade() );
                Log.i("Dados usuario: ", dataSnapshot.getValue().toString() );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        //Passando valores para o obj
        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Rodrigo");
        usuario.setSobrenome("Matos");
        usuario.setIdade(35);

        usuarios.push().setValue( usuario );
         */

        /**Deslogar usuario*/
        //usuario.signOut();

        /**Logar usuario*/
        /*
        usuario.signInWithEmailAndPassword(
                "jamilton2@gmail.com", "ja12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful() ){
                            Log.i("signIn", "Sucesso ao logar usuario!" );
                        }else {
                            Log.i("signIn", "Erro ao logar usuario!" );
                        }
                    }
                });*/

        /**Verifica usuario logado*/
/*        if( usuario.getCurrentUser() != null ){
            Log.i("CurrentUser", "Usuario logado!" );
        }else {
            Log.i("CurrentUser", "Usuario nao logado!" );
        }*/

        /**Cadastro de usuario*/
        /*
        usuario.createUserWithEmailAndPassword(
                "jamilton2@gmail.com", "ja12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful() ){
                            Log.i("CreateUser", "Sucesso ao cadastrar usuario!" );
                        }else {
                            Log.i("CreateUser", "Erro ao cadastrar usuario!" );
                        }
                    }
                });*/

        /*
        DatabaseReference usuarios = referencia.child( "usuarios" );
        DatabaseReference produtos = referencia.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString() );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        /** Salvar dados no Firebase*/
//        Usuario usuario = new Usuario();
//        usuario.setNome("Maria");
//        usuario.setSobrenome("Silva");
//        usuario.setIdade(45);
//
//        Produto produto = new Produto();
//        produto.setDescricao("Acer Aspire");
//        produto.setMarca("Acer");
//        produto.setPreco(999.99);
//
//        produtos.child("002").setValue( produto );
//
//        //usuarios.child("002").setValue(  );

    }

}
