package com.microsoft.gestao_projetos.DTOTest.responseTest;

import com.microsoft.gestao_projetos.DTO.response.ProjetoResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetoResponseTest {

    @Test
    void testProjetoResponse() {
        ProjetoResponse response = new ProjetoResponse(1L, "Projeto Teste", "PENDENTE", 2L, "Cliente Teste");

        assertEquals(1L, response.id_projeto());
        assertEquals("Projeto Teste", response.nome());
        assertEquals("PENDENTE", response.status());
        assertEquals(2L, response.id_cliente());
        assertEquals("Cliente Teste", response.nome_cliente());
    }
}