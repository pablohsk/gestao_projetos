<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="descricao">Descrição:</label>
        <input type="text" v-model="descricao" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="status">Status:</label>
        <input type="text" v-model="status" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="idProjeto">ID Projeto:</label>
        <input type="number" v-model="idProjeto" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</template>

<script>
import atividadeService from '@/services/atividadeService'

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
        this.descricao = ''
        this.status = ''
        this.idProjeto = null
        this.$emit('atividade-saved')
      } catch (error) {
        console.error('Erro ao criar atividade:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>
