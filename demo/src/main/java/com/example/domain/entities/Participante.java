package com.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "participante")
@Inheritance(strategy = InheritanceType.JOINED)
public class Participante {

    @Id
    private Long cod;

    private String nome;

    public Participante() {}

    public Participante(Long cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

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
}
