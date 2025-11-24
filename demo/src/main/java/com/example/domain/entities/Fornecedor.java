package com.example.domain.entities;

import com.example.domain.entities.enums.Area;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Participante {

    private String data_fundacao;

    @Enumerated(EnumType.STRING)
    private Area area;

    public Fornecedor() {}

    public Fornecedor(Long cod, String nome, String data_fundacao, Area area) {
        super(cod, nome);
        this.data_fundacao = data_fundacao;
        this.area = area;
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
