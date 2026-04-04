package org.fab.sisrecruta.servicies;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.entities.PunicaoEntity;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.projections.dtos.PunicaoDTO;
import org.fab.sisrecruta.projections.records.PunicaoRecord;
import org.fab.sisrecruta.repositories.PunicaoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PunicaoService {

    private final PunicaoRepository punicaoRepository;
    private final RecrutaService recrutaService;
    private final MembroCoordenacaoService membroCoordenacaoService;

    @Transactional
    public PunicaoDTO createPunicao(PunicaoRecord record) throws Exception {
        RecrutaEntity recruta = recrutaService.findById(record.idRecuta());

        MembroCoordenacaoEntity membro = membroCoordenacaoService.findById(record.idMembro());

        PunicaoEntity punicao = PunicaoEntity.builder()
                .recruta(recruta)
                .idMembroCoordenacao(membro.getId())
                .dtHora(record.dtHora())
                .descricao(record.descricao())
                .idPunicaoAplicada(record.idPunicaoAplicavel())
                .classificacao(record.classificacao())
                .build();

        punicaoRepository.save(punicao);
        return new PunicaoDTO(punicao);
    }
}
