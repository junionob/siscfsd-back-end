package org.fab.sisrecruta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_ALOJAMENTO")
public class AlojamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NM_ALOJAMENTO", length = 100)
    private String nmAlojamento;

    @OneToMany(mappedBy = "alojamento")
    private List<ArmarioEntity> armarios;

}
