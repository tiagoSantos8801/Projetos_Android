package com.example.apklistatarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

     private Long idTarefa;
     private String nomeTarefa;

     public Long getIdTarefa() {
          return idTarefa;
     }

     public void setIdTarefa(Long idTarefa) {
          this.idTarefa = idTarefa;
     }

     public String getNomeTarefa() {
          return nomeTarefa;
     }

     public void setNomeTarefa(String nomeTarefa) {
          this.nomeTarefa = nomeTarefa;
     }
}
