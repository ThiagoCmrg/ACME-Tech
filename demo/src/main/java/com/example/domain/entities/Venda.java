package com.example.domain.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda {
    
    @Id
    private Long num;

    @Temporal(TemporalType.DATE)
    private Date data;

    private Double valorFinal;
    
    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    private Tecnologia tecnologia;
    
    @ManyToOne
    @JoinColumn(name = "comprador_cod")
    private Comprador comprador;
    
    private Boolean removida;

    public Venda() {}

    public Venda(Long num, Date data, Double valorFinal, Tecnologia tecnologia, Comprador comprador) {
        this.num = num;
        this.data = data;
        this.valorFinal = valorFinal;
        this.tecnologia = tecnologia;
        this.comprador = comprador;
        this.removida = false;
    }

    public Long getNum() { return num; }
    public void setNum(Long num) { this.num = num; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Double getValorFinal() { return valorFinal; }
    public void setValorFinal(Double valorFinal) { this.valorFinal = valorFinal; }

    public Tecnologia getTecnologia() { return tecnologia; }
    public void setTecnologia(Tecnologia tecnologia) { this.tecnologia = tecnologia; }

    public Comprador getComprador() { return comprador; }
    public void setComprador(Comprador comprador) { this.comprador = comprador; }

    public Boolean getRemovida() { return removida; }
    public void setRemovida(Boolean removida) { this.removida = removida; }
}
