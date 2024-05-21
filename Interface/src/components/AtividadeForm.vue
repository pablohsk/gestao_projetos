<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="descricao">Descrição:</label>
        <input type="text" v-model="descricao" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="status">Status:</label>
        <select v-model="status" class="form-control" required>
          <option value="PENDENTE">Pendente</option>
          <option value="EM_PROGRESSO">Em Progresso</option>
          <option value="CONCLUIDA">Concluída</option>
        </select>
      </div>
      <div class="form-group">
        <label for="id_projeto">ID Projeto:</label>
        <input type="number" v-model="id_projeto" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</template>

<script>
import atividadeService from '@/services/atividadeService';

export default {
  data() {
    return {
      descricao: '',
      status: 'PENDENTE', // Definir o status inicial como 'Pendente'
      id_projeto: null
    }
  },
  methods: {
    async handleSubmit() {
      try {
        if (this.descricao && this.status && this.id_projeto !== null) {
          await atividadeService.createAtividade({
            descricao: this.descricao,
            status: this.status, // Passar o status selecionado corretamente
            id_projeto: this.id_projeto
          });
          console.log('Atividade criada com sucesso');
          this.descricao = ''; // Resetar o campo de descrição após a criação bem-sucedida
          this.status = 'PENDENTE'; // Resetar o campo de status para 'Pendente' após a criação bem-sucedida
          this.id_projeto = null; // Resetar o campo de idProjeto após a criação bem-sucedida
          this.$emit('atividade-saved');
        } else {
          console.error('Erro ao criar atividade: campos obrigatórios não preenchidos');
        }
      } catch (error) {
      }
    }
  }
}
</script>

<style scoped>
</style>
