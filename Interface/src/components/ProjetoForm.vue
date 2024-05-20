<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" v-model="nome" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="idCliente">ID Cliente:</label>
        <input type="number" v-model="idCliente" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</template>

<script>
import projetoService from '@/services/projetoService'

export default {
  data() {
    return {
      nome: '',
      idCliente: null
    }
  },
  methods: {
    async handleSubmit() {
      try {
        await projetoService.createProjeto({
          nome: this.nome,
          idCliente: this.idCliente
        })
        this.nome = ''
        this.idCliente = null
        this.$emit('projeto-saved')
      } catch (error) {
        console.error('Erro ao criar projeto:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>