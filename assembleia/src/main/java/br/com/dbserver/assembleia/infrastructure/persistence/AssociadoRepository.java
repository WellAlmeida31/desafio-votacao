package br.com.dbserver.assembleia.infrastructure.persistence;

import br.com.dbserver.assembleia.domain.associado.entity.Associado;
import br.com.dbserver.assembleia.domain.voto.entity.Voto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociadoRepository extends AbstractRepository<Associado> {
    Optional<Associado> findByCpf(String cpf);
}
