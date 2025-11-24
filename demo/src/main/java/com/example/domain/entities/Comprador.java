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
    
    public Comprador() {}
    
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
