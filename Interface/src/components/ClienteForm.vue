<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" v-model="nome" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</template>

<script>
import clienteService from '@/services/clienteService'

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
        this.nome = ''
        this.$emit('cliente-saved')
      } catch (error) {
        console.error('Erro ao criar cliente:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>