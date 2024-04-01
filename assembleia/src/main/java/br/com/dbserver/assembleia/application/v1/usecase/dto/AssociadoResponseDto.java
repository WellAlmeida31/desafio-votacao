package br.com.dbserver.assembleia.application.v1.usecase.dto;

import br.com.dbserver.assembleia.domain.associado.entity.Associado;
import br.com.dbserver.assembleia.domain.associado.entity.AssociadoStatus;

public record AssociadoResponseDto(Long id, String nome, String cpf, AssociadoStatus status) {
    public AssociadoResponseDto(Associado associado){
        this(associado.getId(), associado.getNome(), associado.getCpf(), associado.getStatus());
    }
}
