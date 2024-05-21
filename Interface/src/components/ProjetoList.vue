<template>
  <div>
    <h2>Lista de Projetos</h2>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Nome</th>
        <th>Status</th>
        <th>Cliente</th>
        <th>Atividades</th>
        <th>Ações</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="projeto in projetos" :key="projeto.id">
        <td>{{ projeto.nome }}</td>
        <td>{{ projeto.status }}</td>
        <td>{{ projeto.clienteId }}</td>
        <td>
          <ul>
            <li v-for="atividade in projeto.atividades" :key="atividade.id">
              {{ atividade.descricao }} - {{ atividade.status }}
            </li>
          </ul>
        </td>
        <td>
          <button class="btn btn-danger" @click="deleteProjeto(projeto.id)">Deletar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import projetoService from '@/services/projetoService';

export default {
  props: {
    projetos: Array
  },
  methods: {
    async deleteProjeto(id) {
      try {
        await projetoService.deleteProjeto(id);
        this.$emit('projeto-deleted');
      } catch (error) {
        console.error('Erro ao deletar projeto:', error);
      }
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

.table td ul {
  list-style-type: none;
  padding: 0;
}

.table td ul li {
  background-color: #ffffff;
  margin: 5px 0;
  padding: 10px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
