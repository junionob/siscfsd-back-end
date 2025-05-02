package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.PunicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PunicaoRepository extends JpaRepository<PunicaoEntity, Long> {

}
