package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
