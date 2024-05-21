<template>
  <div>
    <h2>Lista de Atividades</h2>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Descrição</th>
        <th>Status</th>
        <th>Projeto</th>
        <th>Ações</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="atividade in atividades" :key="atividade.id">
        <td>{{ atividade.descricao }}</td>
        <td>{{ atividade.status }}</td>
        <td>{{ atividade.projeto_id }}</td>
        <td>
          <button class="btn btn-danger" @click="deleteAtividade(atividade.id)">Deletar</button>
          <button class="btn btn-secondary" @click="editAtividade(atividade)">Editar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import atividadeService from '@/services/atividadeService';

export default {
  props: {
    atividades: Array
  },
  methods: {
    async deleteAtividade(id) {
      try {
        await atividadeService.deleteAtividade(id);
        this.$emit('atividade-deleted');
      } catch (error) {
        console.error('Erro ao deletar atividade:', error);
      }
    },
    editAtividade(atividade) {
      this.$emit('edit-atividade', atividade);
    }
  }
};
</script>

<style scoped>
.table {
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.table th, .table td {
  border: none;
  padding: 15px;
  vertical-align: middle;
}

.table th {
  background-color: #007bff;
  color: white;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: #e9ecef;
}
</style>
