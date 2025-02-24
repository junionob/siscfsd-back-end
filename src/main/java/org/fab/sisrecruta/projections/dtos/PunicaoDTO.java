package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.PunicaoEntity;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PunicaoDTO {

     Long id;
     RecrutaDTO recruta;
     ClassificacaoPunicaoEnum classificacao;
     String descricao;
     String punicao;
     LocalDate dtHora;
     MembroCoordenacaoDTO membroCoordenacao;

     public PunicaoDTO(PunicaoEntity entity){
          id = entity.getId();
          recruta = new RecrutaDTO(entity.getRecruta());
          classificacao = entity.getClassificacao();
          punicao = entity.getPunicao();
          descricao = entity.getDescricao();
          dtHora = entity.getDtHora();
          membroCoordenacao = new MembroCoordenacaoDTO(entity.getMembroCoordenacao());
     }
}
