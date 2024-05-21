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
      <tr v-for="(projeto, index) in projetos" :key="projeto.id">
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
          <button class="btn btn-secondary" @click="openModal(projeto)">Alterar</button>
        </td>
      </tr>
      </tbody>
    </table>

    <!-- Modal de edição de projeto -->
    <div class="modal" id="projetoModal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Editar Projeto</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form @submit.prevent="updateProjeto">
              <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" v-model="projetoEdit.nome" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="status">Status:</label>
                <input type="text" v-model="projetoEdit.status" class="form-control" required>
              </div>
              <div class="form-group">
                <label for="clienteId">ID Cliente:</label>
                <input type="number" v-model="projetoEdit.clienteId" class="form-control" required>
              </div>
              <button type="submit" class="btn btn-primary">Salvar Alterações</button>
            </form>
          </div>
        </div>
      </div>
    </div>
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
      projetoEdit: {
        id: null,
        nome: '',
        status: '',
        clienteId: ''
      }
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
    async updateProjeto() {
      try {
        const id = this.projetoEdit.id;
        await projetoService.updateProjeto(id, this.projetoEdit);
        this.$emit('projeto-updated');
      } catch (error) {
        console.error('Erro ao atualizar projeto:', error);
      }
    },
    openModal(projeto) {
      this.projetoEdit = { ...projeto };
      $('#projetoModal').modal('show');
    }
  }
};
</script>

<style scoped>
</style>
