package com.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
    
    @Id
    private Long num;
    
    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    private Tecnologia tecnologia;
    
    @ManyToOne
    @JoinColumn(name = "comprador_cod")
    private Comprador comprador;
    
    private Boolean removida;
    
    public Venda() {
        this.removida = false;
    }
    
    public Venda(Long num, Tecnologia tecnologia, Comprador comprador) {
        this.num = num;
        this.tecnologia = tecnologia;
        this.comprador = comprador;
        this.removida = false;
    }
    
    public Long getNum() {
        return num;
    }
    
    public void setNum(Long num) {
        this.num = num;
    }
    
    public Tecnologia getTecnologia() {
        return tecnologia;
    }
    
    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
    
    public Comprador getComprador() {
        return comprador;
    }
    
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    
    public Boolean getRemovida() {
        return removida;
    }
    
    public void setRemovida(Boolean removida) {
        this.removida = removida;
    }
}
