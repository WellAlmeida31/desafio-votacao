package br.com.dbserver.assembleia.domain.voto.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VotoValor {
    SIM("SIM"),
    NAO("NAO");
    private final String valor;
    VotoValor(String voto) {
        this.valor = voto;
    }

}
