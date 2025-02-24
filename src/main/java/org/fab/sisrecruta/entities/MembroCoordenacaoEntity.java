package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fab.sisrecruta.projections.enums.TipoFuncao;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "T_MEMBROS_COORDENACAO")
public class MembroCoordenacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, name = "NM_GUERRA")
    private String nmGuerra;

    @Column(length = 6, nullable = false, name = "SG_POSTO_GRADUACAO")
    private String sgPostoGraducao;

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_FUNCAO", nullable = false)
    private TipoFuncao funcao;

}
