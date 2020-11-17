package com.eng_sw.ScienceVerge.usuario;

import com.eng_sw.ScienceVerge.pesquisa_cientifica.PesquisaCientifica;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    public List<Usuario> findAllByNomeIgnoreCase(String nome);

    public Usuario findByEmailIgnoreCase(String email);

    public Usuario save(Usuario usuario);



}
