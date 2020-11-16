package com.eng_sw.ScienceVerge.usuario;

import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientifica;
import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private static UsuarioRepository usuarioRepository;

    @Autowired
    public List<Usuario> findAllUsuario() {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario->usuarioList.add(usuario));
        return usuarioList;
    }

    @Autowired
    public static Usuario create(Usuario user) {
        Usuario usuario = usuarioRepository.save(user);
        return usuario;
    }
}
