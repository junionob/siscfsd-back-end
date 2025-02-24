package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.MembroCoordenacaoEntity;
import org.fab.sisrecruta.projections.dtos.MembroCoordenacaoDTO;
import org.fab.sisrecruta.projections.enums.TipoFuncao;
import org.fab.sisrecruta.projections.records.MembroCoordenacaoRecord;
import org.fab.sisrecruta.repositories.MembroCoordenacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembroCoordenacaoService {

    @Autowired
    private MembroCoordenacaoRepository membroCoordenacaoRepository;

    public MembroCoordenacaoDTO adicionarMembroCordenacao(MembroCoordenacaoRecord record, TipoFuncao funcao){
        MembroCoordenacaoEntity membroCoordenacao = MembroCoordenacaoEntity.builder()
                .nmGuerra(record.nmGuerra().toUpperCase())
                .sgPostoGraducao(record.sgPostoGraducao().toUpperCase())
                .funcao(funcao)
                .build();

        membroCoordenacaoRepository.save(membroCoordenacao);
        return new MembroCoordenacaoDTO(membroCoordenacao);
    }

    @Transactional(readOnly = true)
    public List<MembroCoordenacaoDTO> getAllMembrosCoordenacao(){
        List<MembroCoordenacaoEntity> membroCoordenacao =  membroCoordenacaoRepository.findAll();
        return membroCoordenacao.stream().map(MembroCoordenacaoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MembroCoordenacaoEntity findById(Long id){
        return membroCoordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro da coordenação não encontrado!"));
    }
}
