package com.vigjoaopaulo.api_rest_2021.model;

import java.util.Enumeration;

public class Anuncios  {

    private int id;
    private String nomeEmpresa;
    private String nomeProduto;
    private Double preco;
    private String endereco;
    private String numero;
    private String cidade;
    private String estado;
    private Integer nota;


    public Anuncios(){

    }

    public Anuncios(int id, String nomeEmpresa, String nomeProduto, Double preco, String endereco, String numero, String cidade, String estado, Integer nota) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Anuncios{" +
                "id=" + id +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", preco=" + preco +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }

}
