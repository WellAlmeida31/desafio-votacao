package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.ResultadoPautaResponse;

public interface ResultadoDaPautaPorIdUseCase {
    ResultadoPautaResponse resultadoDaPautaPorId(Long id);
}
