package com.microsoft.gestao_projetos.DTO;

import com.microsoft.gestao_projetos.enumeration.StatusAtividade;

public record AtividadeDTO(Long id, String descricao, StatusAtividade status, Long projeto_id) {
}
