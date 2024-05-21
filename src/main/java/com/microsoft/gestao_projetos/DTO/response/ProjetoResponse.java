package com.microsoft.gestao_projetos.DTO.response;

public record ProjetoResponse(Long Id, String nome, String status, Long cliente_id) {
}