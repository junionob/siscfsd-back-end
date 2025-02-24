package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.RecrutaEntity;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResumeDTO {
    String nome;
    Long id;

    public TurmaResumeDTO(RecrutaEntity entity){
        this.nome = entity.getTurma().getNmTurma();
        this.id = entity.getTurma().getIdTurma();
    }
}
