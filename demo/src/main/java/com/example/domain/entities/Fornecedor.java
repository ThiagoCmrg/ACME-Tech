package com.example.domain.entities;

import com.example.domain.entities.enums.Area;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    private Long cod; 

    private String nome;
    private String data_fundacao;
    
    @Enumerated(EnumType.STRING)
    private Area area;

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
