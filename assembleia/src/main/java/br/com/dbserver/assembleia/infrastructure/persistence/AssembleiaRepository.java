package br.com.dbserver.assembleia.infrastructure.persistence;

import br.com.dbserver.assembleia.domain.assembleia.entity.Assembleia;
import org.springframework.stereotype.Repository;

@Repository
public interface AssembleiaRepository extends AbstractRepository<Assembleia> {
}
