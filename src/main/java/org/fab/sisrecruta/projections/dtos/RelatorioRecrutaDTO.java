package org.fab.sisrecruta.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.entities.RecrutaEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioRecrutaDTO {

    private String nmNome;
    private String nmGuerra;
    private Integer nrNumerica;
    private LocalDate dtNascimento;
    private String nmTurma;
    private LocalDate dtIncorporacao;
    private LocalDate dtFormatura;
    private List<PunicaoRelatorioDTO> punicaoRelatorioDTO;


    public  RelatorioRecrutaDTO(RecrutaEntity recruta) {
        this.nmNome = recruta.getNmNome();
        this.nmGuerra = recruta.getNmGuerra();
        this.nrNumerica = recruta.getNrNumerica();
        this.dtNascimento = recruta.getDtNascimento();
        this.nmTurma = recruta.getTurma().getNmTurma();
        this.dtIncorporacao = recruta.getTurma().getDtIncorporacao();
        this.dtFormatura = recruta.getTurma().getDtFormatura();
        this.punicaoRelatorioDTO = recruta.getPunicao().stream().map(PunicaoRelatorioDTO::new).collect(Collectors.toList());
    }
}
