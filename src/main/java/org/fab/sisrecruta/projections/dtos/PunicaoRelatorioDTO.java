package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.PunicaoEntity;
import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PunicaoRelatorioDTO {

    private ClassificacaoPunicaoEnum classificacao;
    private String descricao;
    private String punicao;
    private LocalDate dtHora;
    private String membroCoordenacao;

    public PunicaoRelatorioDTO(PunicaoEntity punicao) {
        this.descricao = punicao.getDescricao();
        this.punicao = punicao.getPunicao();
        this.dtHora = punicao.getDtHora();
        this.classificacao = punicao.getClassificacao();
        this.membroCoordenacao = String.format("%s %s - %s",
                punicao.getMembroCoordenacao().getSgPostoGraducao(),
                punicao.getMembroCoordenacao().getNmGuerra(),
                punicao.getMembroCoordenacao().getFuncao().getDescricao());
    }
}
