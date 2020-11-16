package com.eng_sw.ScienceVerge.pesquisa_cientifica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesquisaCientificaService {

    @Autowired
    private PesquisaCientificaRepository pesquisaCientificaRepository;

    public List<PesquisaCientifica> findAllPesquisasCientificas() {
        List<PesquisaCientifica> pesquisasList = new ArrayList<>();
        pesquisaCientificaRepository.findAll().forEach(pesquisa -> pesquisasList.add(pesquisa));
        return pesquisasList;
    }

    public PesquisaCientifica findPesquisaCientificaById(Long id) throws Exception {
        PesquisaCientifica pesquisas = pesquisaCientificaRepository.findById(id).orElseThrow(() -> new Exception("Not found"));

        return pesquisas;

    }

    public List<PesquisaCientifica> findPesquisaByNome(String nome) {
        List<PesquisaCientifica> pesquisas = pesquisaCientificaRepository.findAllByNomeIgnoreCase(nome);
        return pesquisas;
    }

    public PesquisaCientifica create(PesquisaCientifica pesquisa) {
        PesquisaCientifica pesquisaCientifica = pesquisaCientificaRepository.save(pesquisa);
        return pesquisaCientifica;
    }
}
