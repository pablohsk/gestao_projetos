package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}