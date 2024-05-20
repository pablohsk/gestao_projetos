<template>
    <div class="container">
        <h2>Lista de Projetos</h2>
        <ul>
            <li v-for="projeto in projetos" :key="projeto.id">
                {{ projeto.nome }} - {{ projeto.status }} - Cliente: {{ projeto.clienteId }}
            </li>
        </ul>
    </div>
</template>

<script>
import projetoService from '../services/projetoService'

export default {
    data() {
        return {
            projetos: []
        }
    },
    created() {
        this.fetchProjetos()
    },
    methods: {
        async fetchProjetos() {
            try {
                const response = await projetoService.getAllProjetos()
                this.projetos = response.data
            } catch (error) {
                console.error('Erro ao buscar projetos:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
</style>
