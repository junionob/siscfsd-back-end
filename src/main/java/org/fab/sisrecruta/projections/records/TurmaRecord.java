package org.fab.sisrecruta.projections.records;

import java.time.LocalDate;

public record TurmaRecord(String nome, LocalDate dtIncorporacao,
                        LocalDate dtFormatura) {
}
