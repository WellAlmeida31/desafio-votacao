package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.PautaResponseDto;
import br.com.dbserver.assembleia.domain.pauta.entity.PautaStatus;

public interface iniciarOuFinalizarPautaPorIdUseCase {
    PautaResponseDto iniciarOuFinalizarPauta(Long id, PautaStatus status);

}
