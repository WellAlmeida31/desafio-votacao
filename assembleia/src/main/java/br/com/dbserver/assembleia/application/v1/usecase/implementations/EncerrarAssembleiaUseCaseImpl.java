package br.com.dbserver.assembleia.application.v1.usecase.implementations;

import br.com.dbserver.assembleia.application.v1.usecase.contracts.EncerrarAssembleiaUseCase;
import br.com.dbserver.assembleia.domain.pauta.entity.Pauta;
import br.com.dbserver.assembleia.infrastructure.persistence.AssembleiaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EncerrarAssembleiaUseCaseImpl implements EncerrarAssembleiaUseCase {

    private final AssembleiaRepository repository;

    @Transactional
    @Override
    public void encerrarAssembleiaPorId(Long id) {
         repository.findById(id)
                .orElseThrow(EntityNotFoundException::new)
                 .encerrarAssembleia()
                 .getPautas()
                 .forEach(Pauta::encerrarPauta);
    }
}
