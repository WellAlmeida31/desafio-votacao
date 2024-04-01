package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.AssociadoResponseDto;
import br.com.dbserver.assembleia.domain.associado.entity.AssociadoStatus;

public interface InativarOuAtivarAssociadoPorCpfUseCase {
    AssociadoResponseDto anativarOuAtivarAssociado(String cpf, AssociadoStatus status);
}
