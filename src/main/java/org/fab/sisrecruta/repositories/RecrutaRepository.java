package org.fab.sisrecruta.repositories;

import org.fab.sisrecruta.entities.RecrutaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecrutaRepository extends JpaRepository<RecrutaEntity, Long> {

    List<RecrutaEntity> findByIdTurma(Long idTurma);
}
