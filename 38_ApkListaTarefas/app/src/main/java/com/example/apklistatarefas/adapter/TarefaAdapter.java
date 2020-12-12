package com.example.apklistatarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apklistatarefas.R;
import com.example.apklistatarefas.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

     List<Tarefa> listaTarefas;
     public TarefaAdapter(List<Tarefa> listaTarefas) {
          this.listaTarefas = listaTarefas;
     }

     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View itemLista = LayoutInflater.from(parent.getContext())
                         .inflate(R.layout.lista_tarefa_adapter, parent, false);

          return new MyViewHolder(itemLista);
     }

     @Override
     public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
          Tarefa tarefa = listaTarefas.get(position);
          holder.tarefa.setText( tarefa.getNomeTarefa());
     }

     @Override
     public int getItemCount() {
          return listaTarefas.size();
     }

     public class MyViewHolder extends RecyclerView.ViewHolder{

          TextView tarefa;

          public MyViewHolder(@NonNull View itemView) {
               super(itemView);

               tarefa = itemView.findViewById(R.id.textTarefa);//Acessa a view (lista_tarefa_adapter)
          }
     }
}
