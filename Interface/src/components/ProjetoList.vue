<template>
  <div>
    <h2>Lista de Projetos</h2>
    <ul class="list-group">
      <li class="list-group-item d-flex justify-content-between align-items-center" v-for="projeto in projetos" :key="projeto.id">
        {{ projeto.nome }} - Cliente: {{ projeto.clienteId }}
        <button class="btn btn-danger" @click="deleteProjeto(projeto.id)">Deletar</button>
      </li>
    </ul>
  </div>
</template>

<script>
import projetoService from '@/services/projetoService'

export default {
  props: {
    projetos: Array
  },
  methods: {
    async deleteProjeto(id) {
      try {
        await projetoService.deleteProjeto(id)
        this.$emit('projeto-deleted')
      } catch (error) {
        console.error('Erro ao deletar projeto:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>