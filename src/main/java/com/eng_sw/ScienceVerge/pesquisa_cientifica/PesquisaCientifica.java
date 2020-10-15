package com.eng_sw.ScienceVerge.pesquisa_cientifica;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PESQUISA_CIENTIFICA")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PesquisaCientifica {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "PDF")
    @NotNull
    private String pdf_url;

    @Column(name = "IS_PRIVATE")
    @NotNull
    private Boolean isPrivite;

    //comentario pode ser o valor ou lista de materiais
    @Column(name = "COMENTARIO")
    @NotNull
    private String comentario;

}
