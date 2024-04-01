package br.com.dbserver.assembleia.application.v1.usecase.implementations;

import br.com.dbserver.assembleia.application.v1.usecase.contracts.iniciarOuFinalizarPautaPorIdUseCase;
import br.com.dbserver.assembleia.application.v1.usecase.dto.PautaResponseDto;
import br.com.dbserver.assembleia.domain.pauta.entity.PautaStatus;
import br.com.dbserver.assembleia.infrastructure.persistence.PautaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class iniciarOuFinalizarPautaPorIdUseCaseImpl implements iniciarOuFinalizarPautaPorIdUseCase {

    private final PautaRepository repository;

    @Transactional
    @Override
    public PautaResponseDto iniciarOuFinalizarPauta(Long id, PautaStatus status) {
        return new PautaResponseDto(
                repository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new)
                        .iniciarOuEncerrarPauta(status));
    }
}
