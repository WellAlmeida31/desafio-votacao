package br.com.dbserver.assembleia.application.v1.usecase.implementations;

import br.com.dbserver.assembleia.application.v1.usecase.contracts.CriarAssembleiaUseCase;
import br.com.dbserver.assembleia.application.v1.usecase.dto.AssembleiaRequestDto;
import br.com.dbserver.assembleia.application.v1.usecase.dto.AssembleiaResponseDto;
import br.com.dbserver.assembleia.domain.assembleia.entity.Assembleia;
import br.com.dbserver.assembleia.infrastructure.persistence.AssembleiaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarAssembleiaUseCaseImpl implements CriarAssembleiaUseCase {

    private final AssembleiaRepository repository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public AssembleiaResponseDto criarAssembleia(AssembleiaRequestDto dto) {
        return new AssembleiaResponseDto(repository.save(new Assembleia(dto.nome())));
    }
}
