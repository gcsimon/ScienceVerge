package com.eng_sw.ScienceVerge.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;


        @PostMapping("/usuario/login")
        public ResponseEntity<Usuario> login(@RequestBody Login login) {

            return ResponseEntity.ok().body(usuarioService.login(login.getEmail(), login.getSenha()));
        }

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

        @PostMapping("/usuario/editor")
        public ResponseEntity<Usuario> editor(@RequestBody Usuario user)
        {
            Usuario usuario = usuarioService.findByEmail(user);
            if(usuario == null)
            {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(usuario);
        }
}

