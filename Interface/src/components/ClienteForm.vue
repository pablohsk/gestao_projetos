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
        if (this.nome !== undefined && this.nome !== '') {
          await clienteService.createCliente({nome: this.nome});
          console.log('Cliente criado com sucesso');
          this.nome = ''; // Resetar o campo de nome após a criação bem-sucedida
          console.log('Nome após reset:', this.nome); // Log para verificar o valor de nome após reset
          this.$emit('cliente-saved');
        } else {
          console.error('Erro ao criar cliente');
        }
      } catch (error) {
      }
    }
  }
}
</script>

<style scoped>
</style>
