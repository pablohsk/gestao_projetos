<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" v-model="nome" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="status">Status:</label>
        <select v-model="status" class="form-control" required>
          <option value="PENDENTE">Pendente</option>
          <option value="EM_PROGRESSO">Em Progresso</option>
          <option value="CONCLUIDO">Concluído</option>
        </select>
      </div>
      <div class="form-group">
        <label for="cliente_id">ID Cliente:</label>
        <input type="number" v-model="cliente_id" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</template>

<script>
import projetoService from '@/services/projetoService';

export default {
  data() {
    return {
      nome: '',
      status: 'PENDENTE', // Definir o status inicial como 'Pendente'
      cliente_id: null
    }
  },
  methods: {
    async handleSubmit() {
      try {
        if (this.nome && this.status && this.cliente_id !== null) {
          await projetoService.createProjeto({
            nome: this.nome,
            status: this.status, // Passar o status selecionado corretamente
            cliente_id: this.cliente_id
          });
          console.log('Projeto criado com sucesso');
          this.nome = ''; // Resetar o campo de nome após a criação bem-sucedida
          this.status = 'PENDENTE'; // Resetar o campo de status para 'Pendente' após a criação bem-sucedida
          this.cliente_id = null; // Resetar o campo de idCliente após a criação bem-sucedida
          this.$emit('projeto-saved');
        } else {
          console.error('Erro ao criar projeto: campos obrigatórios não preenchidos');
        }
      } catch (error) {
      }
    }
  }
}
</script>

<style scoped>
</style>
