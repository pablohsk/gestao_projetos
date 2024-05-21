<template>
  <div>
    <h2>{{ isEdit ? 'Editar Projeto' : 'Criar Projeto' }}</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" id="nome" class="form-control" v-model="form.nome" required>
      </div>
      <div class="form-group">
        <label for="status">Status</label>
        <select id="status" class="form-control" v-model="form.status" required>
          <option value="PENDENTE">Pendente</option>
          <option value="EM_PROGRESSO">Em Progresso</option>
          <option value="CONCLUIDA">Concluída</option>
        </select>
      </div>
      <div class="form-group">
        <label for="cliente_id">Cliente ID</label>
        <input type="number" id="cliente_id" class="form-control" v-model="form.cliente_id" required>
      </div>
      <button type="submit" class="btn btn-primary">{{ isEdit ? 'Atualizar' : 'Salvar' }}</button>
    </form>
  </div>
</template>

<script>
import projetoService from '@/services/projetoService';

export default {
  props: {
    projeto: Object
  },
  data() {
    return {
      form: {
        Id: null,
        nome: '',
        status: '',
        cliente_id: ''
      },
      isEdit: false
    };
  },
  watch: {
    projeto: {
      immediate: true,
      handler(newVal) {
        if (newVal) {
          this.form = { ...newVal };
          this.isEdit = true;
        } else {
          this.resetForm();
          this.isEdit = false;
        }
      }
    }
  },
  methods: {
    resetForm() {
      this.form = {
        Id: null,
        nome: '',
        status: '',
        cliente_id: ''
      };
    },
    async submitForm() {
      try {
        if (this.isEdit) {
          await projetoService.updateProjeto(this.form.Id, this.form);
        } else {
          await projetoService.createProjeto(this.form);
        }
        this.$emit('projeto-saved');
        this.resetForm();
      } catch (error) {
        console.error('Erro ao salvar o projeto:', error);
      }
    }
  }
};
</script>

<style scoped>
.form-group {
  margin-bottom: 1rem;
}
</style>
