package com.example.a15_toast_alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Toast
    public void abrindoToast(View view){

        //Instanciando a classe imagem e pegando o context.
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(android.R.drawable.star_big_on);

        //Instanciando a classe TextView e pegando o context.
        TextView textView = new TextView(getApplicationContext());
        textView.setText("Se liga nos paranauê aê mano, quer fuder com meu batalhão?!");

        //Toast costumisavel.
        Toast toast = new Toast(getApplicationContext());
        toast.setView(textView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

        //Toast normalmente chamado.
        /*Toast.makeText(
                getApplicationContext(),
                "Um salve pra galera!!!",
                Toast.LENGTH_LONG
        ).show();*/
        //Serve para que a mensagem configurada acima seja exibida
    }

    //Alert dialog
    public void alertDialog(View view){

        //Instanciar Alertdialog.
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);//Tem que ser this, pois nao é o context global

        //Configurar titulo e menssagem.
        dialog.setTitle("Titulo MSG");
        dialog.setMessage("Mensagem propriamente dita");

        //Configurar cancelamento.
        dialog.setCancelable(false);//Mesmo que clique fora nao sai da mensagem

        //Configurar icone.
        dialog.setIcon(R.drawable.ic_launcher_background);

        //Configurar acoes para Sim ou Nao

        //Sim.
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Acoes do Sim",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        //Nao.
        dialog.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Acoes do Nao",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();

    }
}