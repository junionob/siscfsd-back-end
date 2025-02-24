package org.fab.sisrecruta.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.projections.enums.TipoFuncao;

@Builder
@Table(name = "T_DISCIPLINAS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NM_MATERIA")
    private String nmMateria;

    @Column(name = "CARGA_HORARIA")
    private Long cargaHorario;


}
