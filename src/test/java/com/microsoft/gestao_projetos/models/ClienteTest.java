package com.microsoft.gestao_projetos.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteTest {

    @Test
    void testCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");

        assertEquals(1L, cliente.getId());
        assertEquals("Cliente Teste", cliente.getNome());
    }

    @Test
    void testClienteNoArgsConstructor() {
        Cliente cliente = new Cliente();
        assertNull(cliente.getId());
        assertNull(cliente.getNome());
    }
}
