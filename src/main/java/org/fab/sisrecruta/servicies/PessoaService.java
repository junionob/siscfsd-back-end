package org.fab.sisrecruta.servicies;

import org.fab.sisrecruta.entities.PessoaEntity;
import org.fab.sisrecruta.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void cretePessoa(PessoaEntity pessoa) {
        pessoaRepository.save(pessoa);
    }
}
