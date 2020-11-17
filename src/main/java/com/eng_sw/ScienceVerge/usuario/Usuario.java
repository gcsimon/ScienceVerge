package com.eng_sw.ScienceVerge.usuario;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

    @Entity(name = "USUARIO")
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Usuario {

        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "NOME")
        @NotNull
        private String nome;

        @Column(name = "FUNCAO")
        @NotNull
        private String funcao;

        @Column(name = "LATTES")
        private String lattes;

        @Column(name = "EMAIL")
        @NotNull
        private String email;

        @Column(name = "SENHA")
        @NotNull
        private int senha;
    }
