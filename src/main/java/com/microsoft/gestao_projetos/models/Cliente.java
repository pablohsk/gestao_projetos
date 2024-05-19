package com.microsoft.gestao_projetos.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cliente")
    private Set<Projeto> projetos;

}
