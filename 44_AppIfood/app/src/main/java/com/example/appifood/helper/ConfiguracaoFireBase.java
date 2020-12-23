package com.example.appifood.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfiguracaoFireBase {//Pegando as referencias

     private static DatabaseReference databaseReference;
     private static FirebaseAuth firebaseAuthReference;
     private static StorageReference storageReference;

     public static String getIdUsuario(){
          FirebaseAuth autentificacao = getFirebaseAutentificacao();
          return autentificacao.getCurrentUser().getUid();
     }

     //Retorna a referncia do databaseReference
     public static DatabaseReference getFireBase(){//Referencia do banco - Real-time
          if (databaseReference == null){
               databaseReference = FirebaseDatabase.getInstance().getReference();
          }
          return databaseReference;
     }

     //Retorna a referncia do firebaseAuthReference
     public static FirebaseAuth getFirebaseAutentificacao(){//Instancia da Autenticacao
          if (firebaseAuthReference == null){
               firebaseAuthReference = FirebaseAuth.getInstance();
          }
          return firebaseAuthReference;
     }

     //Retorna a referncia do StorageReference
     public static StorageReference getFirebaseStorage(){//Referencia do storage
          if (storageReference == null){
               storageReference = FirebaseStorage.getInstance().getReference();
          }
          return storageReference;
     }
}
