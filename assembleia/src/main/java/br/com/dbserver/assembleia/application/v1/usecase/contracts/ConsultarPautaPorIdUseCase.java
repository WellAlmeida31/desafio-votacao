package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.PautaResponseDto;

public interface ConsultarPautaPorIdUseCase {
    PautaResponseDto consultarPauta(Long id);
}
