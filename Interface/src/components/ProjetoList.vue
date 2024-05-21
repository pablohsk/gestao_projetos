<template>
  <div>
    <h2>Lista de Projetos</h2>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Nome</th>
        <th>Status</th>
        <th>Cliente</th>
        <th>Ações</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(projeto, index) in projetos" :key="projeto.id">
        <td>{{ projeto.nome }}</td>
        <td>{{ projeto.status }}</td>
        <td>{{ projeto.cliente_id }}</td>
        <td>
          <button class="btn btn-danger" @click="deleteProjeto(projeto.id)">Deletar</button>
          <button class="btn btn-secondary" @click="editProjeto(projeto)">Editar</button>
          <button class="btn btn-secondary" @click="toggleAtividades(index)">Atividades</button>
        </td>
      </tr>
      <tr v-if="showAtividadesIndex !== null">
        <td colspan="4">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Descrição</th>
              <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="atividade in projetos[showAtividadesIndex].atividades" :key="atividade.id">
              <td>{{ atividade.descricao }}</td>
              <td>{{ atividade.status }}</td>
            </tr>
            </tbody>
          </table>
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
  data() {
    return {
      showAtividadesIndex: null
    };
  },
  methods: {
    async deleteProjeto(id) {
      try {
        await projetoService.deleteProjeto(id);
        this.$emit('projeto-deleted');
      } catch (error) {
        console.error('Erro ao deletar projeto:', error);
      }
    },
    editProjeto(projeto) {
      this.$emit('edit-projeto', projeto);
    },
    toggleAtividades(index) {
      this.showAtividadesIndex = this.showAtividadesIndex === index ? null : index;
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
