package com.microsoft.gestao_projetos.DTO.response;

import java.util.List;

public record ProjetoResponse(Long id, String nome, String status, Long cliente_id, List<AtividadeResponse> atividades) {}
