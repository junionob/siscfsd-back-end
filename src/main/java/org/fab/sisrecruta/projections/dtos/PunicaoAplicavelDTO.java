package org.fab.sisrecruta.projections.dtos;

import lombok.Data;
import org.fab.sisrecruta.entities.PunicaoAplicavelEntity;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

@Data
public class PunicaoAplicavelDTO {
    private Long id;
    private ClassificacaoPunicaoEnum classificacao;
    private String txPunicaoAplicavel;

    public PunicaoAplicavelDTO(PunicaoAplicavelEntity entity) {
        this.id = entity.getId();
        this.classificacao = entity.getClassificacao();
        this.txPunicaoAplicavel = entity.getTxPunicaoAplicavel();
    }
}
