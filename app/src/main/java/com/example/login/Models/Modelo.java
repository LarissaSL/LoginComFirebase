package com.example.login.Models;

public class Modelo {

    String nome, email;

    public Modelo(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Modelo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
