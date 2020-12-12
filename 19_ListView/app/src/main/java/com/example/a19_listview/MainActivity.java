package com.example.a19_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Classe ListView
    private ListView listLocais;

    //Criando um array de itens
    String[] itens = {
            "Angra","Caldas","Campos Jordao",
            "Costa do Sauípe","Ilheus","Porto Seguro",
            "Tira Dentes","Praga","Santiago",
            "Zurique","Caribe","Buenos Aires","Budapeste",
            "Cancun","Aruba","Juazeiro do Norte"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando id da ListView
        listLocais = findViewById(R.id.listLocais);

        //Criar adaptador -> Pega os itens do Array(itens) e adapta para o modo de visualisacao
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(

                getApplicationContext(),//Recuperando o context(Acessa o sistema)
                android.R.layout.simple_list_item_1,//Escolhendo um estilo de layout para a listview
                android.R.id.text1,//Id do layout em uso (android:id="@android:id/ -> text1 <-")
                itens//Array de String que sera adaptado para ser visualisado de acordo com o arquivo XML

        );

        //Adcionar adaptador para lista
        listLocais.setAdapter(adaptador);

        //Adcionar click(Toque) na lista e recuperar o que foi tocado.
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(
                        getApplicationContext(),
                         "Local selecionado: " + valorSelecionado,
                        Toast.LENGTH_SHORT
                ).show();

            }//(int position) -> O index do array  (long id) -> Id do View(activity_main)
        });
    }
}