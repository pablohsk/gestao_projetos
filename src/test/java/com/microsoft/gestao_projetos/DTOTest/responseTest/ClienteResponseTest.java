package com.microsoft.gestao_projetos.DTOTest.responseTest;

import com.microsoft.gestao_projetos.DTO.response.ClienteResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteResponseTest {

    @Test
    void testClienteResponse() {
        ClienteResponse response = new ClienteResponse(1L, "Cliente Teste");

        assertEquals(1L, response.id());
        assertEquals("Cliente Teste", response.nome());
    }
}
