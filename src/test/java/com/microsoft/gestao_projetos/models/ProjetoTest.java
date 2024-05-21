package com.microsoft.gestao_projetos.models;

import com.microsoft.gestao_projetos.enumeration.StatusProjeto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjetoTest {

    @Test
    void testProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto Teste");
        projeto.setStatus(StatusProjeto.valueOf("PENDENTE"));
        projeto.setCliente(new Cliente());

        assertEquals(1L, projeto.getId());
        assertEquals("Projeto Teste", projeto.getNome());
        assertEquals("PENDENTE", projeto.getStatus());
        assertNotNull(projeto.getCliente());
    }

    @Test
    void testProjetoNoArgsConstructor() {
        Projeto projeto = new Projeto();
        assertNull(projeto.getId());
        assertNull(projeto.getNome());
        assertNull(projeto.getStatus());
        assertNull(projeto.getCliente());
    }
}
