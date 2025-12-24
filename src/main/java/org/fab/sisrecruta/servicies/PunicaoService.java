package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.entities.PunicaoEntity;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.fab.sisrecruta.projections.dtos.PunicaoDTO;
import org.fab.sisrecruta.projections.records.PunicaoRecord;
import org.fab.sisrecruta.repositories.PunicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunicaoService {

    private final PunicaoRepository punicaoRepository;
    private final RecrutaService recrutaService;
    private final MembroCoordenacaoService membroCoordenacaoService;

    @Autowired
    public PunicaoService(PunicaoRepository punicaoRepository, RecrutaService recrutaService, MembroCoordenacaoService membroCoordenacaoService) {
        this.punicaoRepository = punicaoRepository;
        this.recrutaService = recrutaService;
        this.membroCoordenacaoService = membroCoordenacaoService;
    }

    public PunicaoDTO createPunicao(PunicaoRecord record) throws Exception {
        RecrutaEntity recruta = recrutaService.findById(record.idRecuta());

        MembroCoordenacaoEntity membro = membroCoordenacaoService.findById(record.idMembro());

        PunicaoEntity punicao = PunicaoEntity.builder()
                .recruta(recruta)
                .membroCoordenacao(membro)
                .dtHora(record.dtHora())
                .descricao(record.descricao())
                .punicao(record.punicao())
                .classificacao(record.classificacao())
                .build();

        punicaoRepository.save(punicao);
        return new PunicaoDTO(punicao);
    }
}
