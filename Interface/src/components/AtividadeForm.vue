<template>
    <div class="container">
        <form @submit.prevent="handleSubmit">
            <label>
                Descrição:
                <input type="text" v-model="descricao" required>
            </label>
            <label>
                Status:
                <input type="text" v-model="status" required>
            </label>
            <label>
                ID Projeto:
                <input type="number" v-model="idProjeto" required>
            </label>
            <button type="submit">Salvar</button>
        </form>
    </div>
</template>

<script>
import atividadeService from '../services/atividadeService'

export default {
    data() {
        return {
            descricao: '',
            status: '',
            idProjeto: null
        }
    },
    methods: {
        async handleSubmit() {
            try {
                await atividadeService.createAtividade({
                    descricao: this.descricao,
                    status: this.status,
                    idProjeto: this.idProjeto
                })
                // Limpar campos após salvar com sucesso
                this.descricao = ''
                this.status = ''
                this.idProjeto = null
                // Feedback ao usuário (opcional)
                console.log('Atividade criada com sucesso!')
            } catch (error) {
                console.error('Erro ao criar atividade:', error)
            }
        }
    }
}
</script>

<style scoped>
/* Estilos específicos para este componente */
</style>
