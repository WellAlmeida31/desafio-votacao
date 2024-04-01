package br.com.dbserver.assembleia.domain.pauta.entity;


public enum PautaStatus {
    INICIADA("Iniciada"),
    FINALIZADA("Finalizada");

    private final String situacao;

    PautaStatus(String situacao) {
        this.situacao = situacao;
    }

}
