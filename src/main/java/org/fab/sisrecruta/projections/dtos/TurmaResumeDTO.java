package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.entities.TurmaEntity;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResumeDTO {

    Long id;
    String nome;

    public TurmaResumeDTO(TurmaEntity entity){
        this.nome = entity.getNmTurma();
        this.id = entity.getIdTurma();
    }
}
