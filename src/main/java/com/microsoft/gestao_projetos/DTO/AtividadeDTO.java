package com.microsoft.gestao_projetos.DTO;

import com.microsoft.gestao_projetos.enumeration.StatusAtividade;

public record AtividadeDTO(String descricao, StatusAtividade status, Long id_projeto) {
}
