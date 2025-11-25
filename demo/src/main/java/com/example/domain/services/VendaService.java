package com.example.domain.services;

import com.example.domain.entities.Venda;
import com.example.domain.entities.enums.Area;

public class VendaService {

    public Double calcularValorFinal(Venda venda, long vendasAnteriores) {
        if (venda.getTecnologia() == null) {
            throw new RuntimeException("Venda " + venda.getNum() + " não possui tecnologia associada");
        }

        if (venda.getTecnologia().getFornecedor() == null) {
            throw new RuntimeException("Tecnologia da venda " + venda.getNum() + " não possui fornecedor associado");
        }

        if (venda.getComprador() == null) {
            throw new RuntimeException("Venda " + venda.getNum() + " não possui comprador associado");
        }

        Double valorBase = venda.getTecnologia().getValorBase();
        Area area = venda.getTecnologia().getFornecedor().getArea();

        Double valorComAcrescimo = aplicarAcrescimoPorArea(valorBase, area);

        Double descontoPercentual = Math.min(vendasAnteriores * 1.0, 10.0);
        return valorComAcrescimo * (1 - descontoPercentual / 100);
    }

    private Double aplicarAcrescimoPorArea(Double valorBase, Area area) {
        return switch (area) {
            case TI -> valorBase * 1.20;
            case ANDROIDES -> valorBase * 1.15;
            case EMERGENTE -> valorBase * 1.25;
            case ALIMENTOS -> valorBase * 1.10;
        };
    }
}
