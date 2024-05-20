<template>
    <div class="container">
        <h2>Lista de Atividades</h2>
        <ul>
            <li v-for="atividade in atividades" :key="atividade.id">
                {{ atividade.descricao }} - {{ atividade.status }} - Projeto: {{ atividade.projetoId }}
            </li>
        </ul>
    </div>
</template>

<script>
import atividadeService from '../services/atividadeService'

export default {
    data() {
        return {
            atividades: []
        }
    },
    created() {
        this.fetchAtividades()
    },
    methods: {
        async fetchAtividades() {
            try {
                const response = await atividadeService.getAllAtividades()
                this.atividades = response.data
            } catch (error) {
                console.error('Erro ao buscar atividades:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
</style>
