package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByProjetoId(Long projetoId);
}