package com.eng_sw.ScienceVerge.pesquisa_cientifica;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesquisaCientificaRepository extends PagingAndSortingRepository<PesquisaCientifica, Long> {

    public List<PesquisaCientifica> findAllByNomeIgnoreCase(String nome);

    public PesquisaCientifica save(PesquisaCientifica pesquisaCientifica);

}
