package com.example.a21_cardview.Model;

public class Postagem {

    private  String nome, postagem;
    private int imgem;//Pq a imagem passada é um numero inteiro

    public Postagem(){

    }

    public Postagem(String nome, String postagem, int imgem) {
        this.nome = nome;
        this.postagem = postagem;
        this.imgem = imgem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImgem() {
        return imgem;
    }

    public void setImgem(int imgem) {
        this.imgem = imgem;
    }
}
