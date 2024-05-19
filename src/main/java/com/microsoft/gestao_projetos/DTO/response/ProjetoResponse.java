package com.microsoft.gestao_projetos.DTO.response;

public record ProjetoResponse(Long id_projeto, String nome, String status, Long id_cliente, String nome_cliente) {
}
