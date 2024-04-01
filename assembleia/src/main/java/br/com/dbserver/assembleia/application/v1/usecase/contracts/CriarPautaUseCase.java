package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.PautaRequestDto;
import br.com.dbserver.assembleia.application.v1.usecase.dto.PautaResponseDto;

public interface CriarPautaUseCase {

    PautaResponseDto criarPauta(PautaRequestDto dto);
}
