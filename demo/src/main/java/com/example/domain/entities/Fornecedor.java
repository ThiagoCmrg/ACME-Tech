package com.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    private Long cod; 

    private String nome;
    private String data_fundacao;
    private String area;

    public Fornecedor() {}

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(String data_fundacao) {
        this.data_fundacao = data_fundacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
