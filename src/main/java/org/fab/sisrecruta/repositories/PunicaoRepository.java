package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.PunicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunicaoRepository extends JpaRepository<PunicaoEntity, Long> {
}
