package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.AssociadoResponseDto;

public interface ConsultarAssociadoPorCpfUseCase {
    AssociadoResponseDto consultarAssociadoPorCpf(String cpf);
}
