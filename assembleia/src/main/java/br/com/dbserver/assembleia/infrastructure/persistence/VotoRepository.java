package br.com.dbserver.assembleia.infrastructure.persistence;

import br.com.dbserver.assembleia.domain.associado.entity.Associado;
import br.com.dbserver.assembleia.domain.pauta.entity.Pauta;
import br.com.dbserver.assembleia.domain.voto.entity.Voto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends AbstractRepository<Voto> {
    boolean existsByAssociadosAndPautas(List<Associado> associados, List<Pauta> pautas);
}
