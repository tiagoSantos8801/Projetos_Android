package com.example.entendendofirebase;

public class Usuario {

     String nome, cpf;
     int idade;

     public Usuario() {//O FireBase obriga ter um constructor,Default
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public int getIdade() {
          return idade;
     }

     public void setIdade(int idade) {
          this.idade = idade;
     }

     public String getCpf() {
          return cpf;
     }

     public void setCpf(String cpf) {
          this.cpf = cpf;
     }



}
