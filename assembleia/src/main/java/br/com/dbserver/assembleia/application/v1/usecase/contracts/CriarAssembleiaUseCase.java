package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.AssembleiaRequestDto;
import br.com.dbserver.assembleia.application.v1.usecase.dto.AssembleiaResponseDto;

public interface CriarAssembleiaUseCase {
    AssembleiaResponseDto criarAssembleia(AssembleiaRequestDto dto);
}
