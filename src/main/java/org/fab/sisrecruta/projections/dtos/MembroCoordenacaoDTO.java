package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.projections.enums.TipoFuncao;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembroCoordenacaoDTO {
    Long id;
    String nmGuerra;
    String sgPostoGraducao;
    TipoFuncao funcao;

    public MembroCoordenacaoDTO(MembroCoordenacaoEntity entity){
        id = entity.getId();
        nmGuerra = entity.getNmGuerra();
        sgPostoGraducao = entity.getSgPostoGraducao();
        funcao = entity.getFuncao();
    }
}
