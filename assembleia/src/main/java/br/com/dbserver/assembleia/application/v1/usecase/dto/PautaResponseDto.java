package br.com.dbserver.assembleia.application.v1.usecase.dto;

import br.com.dbserver.assembleia.domain.pauta.entity.Pauta;
import br.com.dbserver.assembleia.domain.pauta.entity.PautaStatus;

import java.time.LocalDateTime;

public record PautaResponseDto(Long id, String descricao, PautaStatus status, LocalDateTime inicio, LocalDateTime fim) {
    public PautaResponseDto(Pauta pauta) {
        this(pauta.getId(), pauta.getDescricao(), pauta.getStatus(), pauta.getInicio(), pauta.getFim());
    }
}
