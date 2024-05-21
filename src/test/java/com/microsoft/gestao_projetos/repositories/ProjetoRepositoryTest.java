package com.microsoft.gestao_projetos.repositories;

import com.microsoft.gestao_projetos.models.Cliente;
import com.microsoft.gestao_projetos.models.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProjetoRepositoryTest {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testFindByClienteId() {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        clienteRepository.save(cliente);

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste");
        projeto.setCliente(cliente);
        projetoRepository.save(projeto);

        List<Projeto> projetos = projetoRepository.findAll();
        assertEquals(1, projetos.size());
        assertEquals("Projeto Teste", projetos.get(0).getNome());
    }
}
