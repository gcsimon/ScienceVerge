package com.eng_sw.ScienceVerge.usuario;

import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientifica;
import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientificaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UsuarioController {

        @Autowired
        private Usuario usuario;
        private UsuarioService usuarioService;

        @PostMapping("/usuario/create")
        public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
            Usuario usuario = usuarioService.create(user);

            if (usuario == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(usuario);
        }

        @GetMapping("/usuario")
        public ResponseEntity<List<Usuario>> findAll()
        {
            List<Usuario> usuarioList = usuarioService.findAllUsuario();

            if(usuarioList == null)
            {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(usuarioList);
        }
}

