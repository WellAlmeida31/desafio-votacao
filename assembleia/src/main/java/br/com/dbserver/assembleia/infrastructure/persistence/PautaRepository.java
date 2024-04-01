package br.com.dbserver.assembleia.infrastructure.persistence;

import br.com.dbserver.assembleia.domain.pauta.entity.Pauta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PautaRepository extends AbstractRepository<Pauta> {

    @Query("""
    select p from Pauta p
    where p.fim < CURRENT_TIMESTAMP
    and p.status = 'INICIADA'
    """)
    List<Pauta> findByFimBeforeNowAndStatus_Iniciada();
}
