package com.microsoft.gestao_projetos.DTOTest;

import com.microsoft.gestao_projetos.DTO.ClienteDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteDTOTest {

    @Test
    void testClienteDTO() {
        ClienteDTO clienteDTO = new ClienteDTO(1L, "Cliente Teste");

        assertEquals("Cliente Teste", clienteDTO.nome());
    }
}