package com.example.myapplication.modelos;

import java.io.Serializable;

public class DepartamentoBean implements Serializable {
    String id;
    String nome;
    String data;
    String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String data) {
        this.status = data;
    }


    @Override
    public String toString() {
        return "                 <<< DEPARTAMENTO BEAN >>>\n\n" + "ID= " + id + "\nNOME= " + nome + "\nDATA= " + data + "\nSTATUS= " + status + "\n";
    }
}
