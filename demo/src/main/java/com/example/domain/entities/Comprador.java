package com.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "comprador")
public class Comprador extends Participante {

    private String email;
    private String pais;

    public Comprador() {}

    public Comprador(Long cod, String nome, String email, String pais) {
        super(cod, nome);
        this.email = email;
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
