package com.microsoft.gestao_projetos.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "projeto")
    private Set<Atividade> atividades;


}
