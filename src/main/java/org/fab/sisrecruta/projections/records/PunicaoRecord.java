package org.fab.sisrecruta.projections.records;

import org.fab.sisrecruta.projections.enums.ClassificacaoPunicaoEnum;

import java.time.LocalDate;

public record PunicaoRecord(Long idRecuta,
                            Long idMembro,
                            ClassificacaoPunicaoEnum classificacao,
                            String descricao,
                            String punicao,
                            LocalDate dtHora ) {
}
