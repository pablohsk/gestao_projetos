<template>
    <div class="container">
        <form @submit.prevent="handleSubmit">
            <label>
                Nome:
                <input type="text" v-model="nome" required>
            </label>
            <button type="submit">Salvar</button>
        </form>
    </div>
</template>

<script>
import clienteService from '../services/clienteService'

export default {
    data() {
        return {
            nome: ''
        }
    },
    methods: {
        async handleSubmit() {
            try {
                await clienteService.createCliente({ nome: this.nome })
                // Limpar campo após salvar com sucesso
                this.nome = ''
                // Feedback ao usuário (opcional)
                console.log('Cliente criado com sucesso!')
            } catch (error) {
                console.error('Erro ao criar cliente:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
</style>
