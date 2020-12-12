package com.example.a20_recicleview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20_recicleview.Model.Filme;
import com.example.a20_recicleview.R;

import java.util.List;


//Os objetos do fixador de visualização são gerenciados por um adaptador,
// que você cria estendendo RecyclerView.Adapter
//Objetos fixadores
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHoleder> {

    List<Filme> lista;

    public  Adapter(List<Filme> lista){
        this.lista = lista;
    }


    // O adaptador também vincula os fixadores de visualização aos respectivos dados.
    // Isso é feito atribuindo o fixador de visualização a uma posição e chamando o método onBindViewHolder()
    // do adaptador.
    //Cria a quantidade de Views que aparece natela so!
    //Para criar essa visualizacao temos que criar o XML
    //Cria
    @NonNull
    @Override                                               //(parent) -> Itens de lista recyclerview
    public MyViewHoleder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //Converter o Layout(XML) em um objeto do tipo View.
        //A classe que converte o XML em View ->    (LayoutInflater())
        //O (parente) guarda os itens de lista, e assim acessa-se o context
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.adapter_lista,//O item de lista(Layout - XML).
                        parent,//Itens de lista - as Views.
                        false // Adciona o item de lista ao elemento Root.
                );

        return new MyViewHoleder(itemLista);
        //Temos que passar esse item de lista para o MyViewHoleder()
        //pois e essa classe que vai configurar os dados dentro desta visualisacao
    }


    //Exibe
    @Override                                         //Obj holder -> MyViewHoleder
    public void onBindViewHolder(@NonNull MyViewHoleder holder, int position) {

        //position posicao do item no recyclerview
        //Setando os campos capturados no XML pelo MyViewHoleder
        Filme filme = lista.get(position);//Lista de obj filmes
        holder.titulo.setText(filme.getTitulo());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());
    }


    //Contagem de Itens -> Retorna a quantidade de itens que vao ser exibidos
    @Override
    public int getItemCount() {
        return lista.size();
    }
//--------------------------------------------------------------------------------------------------


    //Inner class ViewHolder
//------------------------------
    //Classe que cria os objetos fixadores de visualização(VH -> ViewHolder)
    //Esses objetos são instâncias de uma classe que você define estendendo(RecyclerView.ViewHolder)

    public class MyViewHoleder extends RecyclerView.ViewHolder {


        // Fixadores de visualização.
        TextView titulo , ano, genero;// Guarda esses objs e passa, atravez do construtor,
        // para a classe pai -> (Adapter) a View organizada.

        // Construtor.
        public MyViewHoleder(@NonNull View itemView) {//Espera um obj View para configuralo(XML)
            //TextView tituol, ano, genero
            // itemView -> acessa os Ids(objs) dentro do "XML" agora View
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);//Acessa XML
            ano    = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }
}
//https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br