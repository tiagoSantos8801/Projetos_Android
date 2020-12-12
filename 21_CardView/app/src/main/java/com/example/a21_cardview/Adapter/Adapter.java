package com.example.a21_cardview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a21_cardview.Model.Postagem;
import com.example.a21_cardview.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //Passa a lista pelo construtor
    List<Postagem> listaPost = new ArrayList<>();
    public Adapter(
            List<Postagem> listaPost) {
        this.listaPost = listaPost;
    }

    //Cria
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.postagem_detalhe,
                parent,
                false
        );

        return new MyViewHolder(itemLista);
    }

    //Exibe
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagem post;
        post = listaPost.get(position);
        holder.textNome.setText(post.getNome());//Acessa a view(holder)
        holder.imagePostagem.setImageResource(post.getImgem());//indentificador numerico
        holder.textPostagem.setText(post.getPostagem());

    }

    //Numero de postagens
    @Override
    public int getItemCount() {
        return listaPost.size();
    }


    //Inner class
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textNome, textPostagem;
        ImageView imagePostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textNome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);

        }
    }
}
