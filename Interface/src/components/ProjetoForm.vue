<template>
    <div class="container">
        <form @submit.prevent="handleSubmit">
            <label>
                Nome:
                <input type="text" v-model="nome" required>
            </label>
            <label>
                Status:
                <input type="text" v-model="status" required>
            </label>
            <label>
                ID Cliente:
                <input type="number" v-model="idCliente" required>
            </label>
            <button type="submit">Salvar</button>
        </form>
    </div>
</template>

<script>
import projetoService from '../services/projetoService'

export default {
    data() {
        return {
            nome: '',
            status: '',
            idCliente: null
        }
    },
    methods: {
        async handleSubmit() {
            try {
                await projetoService.createProjeto({
                    nome: this.nome,
                    status: this.status,
                    cliente: this.idCliente
                })
                // Limpar campos após salvar com sucesso
                this.nome = ''
                this.status = ''
                this.idCliente = null
                // Feedback ao usuário (opcional)
                console.log('Projeto criado com sucesso!')
            } catch (error) {
                console.error('Erro ao criar projeto:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
</style>
