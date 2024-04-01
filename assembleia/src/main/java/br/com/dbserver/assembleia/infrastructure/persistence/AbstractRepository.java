package br.com.dbserver.assembleia.infrastructure.persistence;

import br.com.dbserver.assembleia.domain.base.EntityBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T extends EntityBase> extends JpaRepository<T, Long> {
}
