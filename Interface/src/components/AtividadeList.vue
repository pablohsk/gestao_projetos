<template>
  <div>
    <h2>Lista de Atividades</h2>
    <ul class="list-group">
      <li class="list-group-item d-flex justify-content-between align-items-center" v-for="atividade in atividades" :key="atividade.id">
        {{ atividade.descricao }} - {{ atividade.status }} - Projeto: {{ atividade.projetoId }}
        <button class="btn btn-danger" @click="deleteAtividade(atividade.id)">Deletar</button>
      </li>
    </ul>
  </div>
</template>

<script>
import atividadeService from '@/services/atividadeService'

export default {
  props: {
    atividades: Array
  },

  methods: {
    async deleteAtividade(id) {
      try {
        await atividadeService.deleteAtividade(id)
        this.$emit('atividade-deleted')
      } catch (error) {
        console.error('Erro ao deletar atividade:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>
