package com.eng_sw.ScienceVerge.pesquisa_cientifica;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity(name = "PESQUISA_CIENTIFICA")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PesquisaCientifica {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "PDF")
    @NotNull
    private String pdf_url;

    @Column(name = "IS_PRIVATE")
    @NotNull
    private Boolean isPrivate;

    @Column(name = "ATIVA")
    @NotNull
    private Boolean Ativa;

    //comentario pode ser o valor ou lista de materiais
    @Column(name = "COMENTARIO")
    @NotNull
    private String comentario;

}
