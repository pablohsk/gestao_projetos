<template>
    <div class="container">
        <h2>Lista de Clientes</h2>
        <ul>
            <li v-for="cliente in clientes" :key="cliente.id">
                {{ cliente.nome }}
            </li>
        </ul>
    </div>
</template>

<script>
import clienteService from '../services/clienteService'

export default {
    data() {
        return {
            clientes: []
        }
    },
    created() {
        this.fetchClientes()
    },
    methods: {
        async fetchClientes() {
            try {
                const response = await clienteService.getAllClientes()
                this.clientes = response.data
            } catch (error) {
                console.error('Erro ao buscar clientes:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
.container {
    max-width: 600px;
    margin: 0 auto;
}
</style>
