package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.AssembleiaResponseDto;

public interface ConsultaAssembleiaPorIdUseCase {
    AssembleiaResponseDto consultaAssembleiaPorId(Long id);
}
