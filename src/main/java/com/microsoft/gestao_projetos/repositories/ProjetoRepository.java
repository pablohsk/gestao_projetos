package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByClienteId(Long clienteId);
}