package br.com.dbserver.assembleia.application.v1.usecase.dto;

import br.com.dbserver.assembleia.application.v1.validation.Cpf;
import br.com.dbserver.assembleia.domain.voto.entity.VotoValor;
import jakarta.validation.constraints.NotNull;

public record VotoRequestDto(
        @NotNull VotoValor votoValor,
        @Cpf String cpf,
        @NotNull Long pautaId) {
}
