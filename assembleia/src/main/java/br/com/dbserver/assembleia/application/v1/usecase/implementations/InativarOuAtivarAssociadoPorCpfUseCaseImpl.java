package br.com.dbserver.assembleia.application.v1.usecase.implementations;

import br.com.dbserver.assembleia.application.v1.usecase.contracts.InativarOuAtivarAssociadoPorCpfUseCase;
import br.com.dbserver.assembleia.application.v1.usecase.dto.AssociadoResponseDto;
import br.com.dbserver.assembleia.domain.associado.entity.AssociadoStatus;
import br.com.dbserver.assembleia.infrastructure.persistence.AssociadoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InativarOuAtivarAssociadoPorCpfUseCaseImpl implements InativarOuAtivarAssociadoPorCpfUseCase {

    private final AssociadoRepository repository;

    @Transactional
    @Override
    public AssociadoResponseDto anativarOuAtivarAssociado(String cpf, AssociadoStatus status) {
        return new AssociadoResponseDto(
                repository
                        .findByCpf(cpf)
                        .orElseThrow(EntityNotFoundException::new)
                        .inativarOuAtivar(status));
    }
}
