package com.example.myapplication.modelos;

import java.io.Serializable;

public class EmpresaBean implements Serializable {
    String id;
    int id_d;
    String cnpj;
    String tipo;
    String nome;
    String data;
    String status;


    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return "                       <<< EMPRESA BEAN >>>\n\n" + "ID= " + id + "\nCNPJ= " + cnpj + "\nTIPO= " + tipo + "\nNOME= " + nome + "\nDATA= " + data + "\nSTATUS= " + status + "\nID DO DEPARTAMENTO= " + id_d + "\n";
    }
}
