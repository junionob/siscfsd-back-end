package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.DisciplinaEntity;
import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.projections.enums.TipoFuncao;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResponsavelDTO {

    Long id;
    DisciplinaEntity disciplina;
    MembroCoordenacaoEntity membroCoordenacao;
    TipoFuncao tipoFuncao;
}
