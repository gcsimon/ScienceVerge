package com.eng_sw.ScienceVerge.pesquisa_cientifica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PesquisaCientificaController {

    @Autowired
    private PesquisaCientificaService pesquisaCientificaService;

    //localhost:8080/pesquisa-cientifica
    @GetMapping(value = "/pesquisa-cientifica")
    public ResponseEntity<List<PesquisaCientifica>> getAllPesquisasCientificas() {

        List<PesquisaCientifica> pesquisas = pesquisaCientificaService.findAllPesquisasCientificas();
        return ResponseEntity.ok().body(pesquisas);

    }

    //localhost:8080/pesquisa-cientifica/nome
    @GetMapping(value = "/pesquisa-cientifica/{nome}")
    public ResponseEntity<List<PesquisaCientifica>> searchPesquisasCientificas(@PathVariable("nome") String nome) {

        List<PesquisaCientifica> pesquisas = pesquisaCientificaService.findPesquisaByNome(nome);
        return ResponseEntity.ok().body(pesquisas);

    }

/*
curl -X POST \
  http://localhost:8080/pesquisa-cientifica/create \
  -H 'Content-Type: application/json' \
  -d '{
	"nome": "pesquisa3",
	"pdf_url": "www.google.com/pdf3",
	"isPrivate": true,
	"comentario": "vai custar caro"
}'
 */
    @PostMapping("/pesquisa-cientifica/create")
    public ResponseEntity<PesquisaCientifica> create(@RequestBody PesquisaCientifica pesquisa) {
        PesquisaCientifica pesquisaCientifica = pesquisaCientificaService.create(pesquisa);
        if (pesquisaCientifica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pesquisaCientifica);

    }
}
