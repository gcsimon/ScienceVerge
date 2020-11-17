package com.eng_sw.ScienceVerge.usuario;

import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientifica;
import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsuario() {
        List<Usuario> usuarioList = new ArrayList<>();

        usuarioRepository.findAll().forEach(user -> usuarioList.add(user));

        return usuarioList;
    }

    public Usuario create(Usuario user) {
        Usuario usuario = usuarioRepository.save(user);
        return usuario;
    }

    public Usuario login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmailIgnoreCase(email);

        if(usuario.getSenha().equals(password)){
            return usuario;
        }
        else {
            return new Usuario();
        }
    }
}
