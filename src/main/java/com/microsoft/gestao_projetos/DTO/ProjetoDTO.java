package com.microsoft.gestao_projetos.DTO;

import com.microsoft.gestao_projetos.DTO.response.AtividadeResponse;

import java.util.List;

public record ProjetoDTO(Long id, String nome, String status, Long cliente_id, List<AtividadeResponse> atividades) {
}