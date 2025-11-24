package com.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comprador")
public class Comprador {
    
    @Id
    private Long cod;
    
    private String nome;
    private String email;
    private String pais;
    
    public Comprador() {}

    public Comprador(Long cod, String nome, String email, String pais) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
