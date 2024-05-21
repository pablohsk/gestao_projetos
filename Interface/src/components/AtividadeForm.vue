<template>
  <div class="mb-4">
    <h2>{{ isEdit ? 'Editar Atividade' : 'Criar Atividade' }}</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="descricao">Descrição</label>
        <input type="text" id="descricao" class="form-control" v-model="form.descricao" required>
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
        <label for="projeto_id">Projeto ID</label>
        <input type="number" id="projeto_id" class="form-control" v-model="form.projeto_id" required>
      </div>
      <button type="submit" class="btn btn-primary">{{ isEdit ? 'Atualizar' : 'Salvar' }}</button>
    </form>
  </div>
</template>

<script>
import atividadeService from '@/services/atividadeService';

export default {
  props: {
    atividade: Object
  },
  data() {
    return {
      form: {
        id: null,
        descricao: '',
        status: 'PENDENTE', // Definindo um valor padrão para status
        projeto_id: null
      },
      isEdit: false
    };
  },
  watch: {
    atividade: {
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
        id: null,
        descricao: '',
        status: 'PENDENTE',
        projeto_id: null
      };
    },
    async submitForm() {
      try {
        if (this.isEdit) {
          await atividadeService.updateAtividade(this.form.id, this.form);
        } else {
          await atividadeService.createAtividade(this.form);
        }
        this.$emit('atividade-saved');
        this.resetForm();
      } catch (error) {
        console.error('Erro ao salvar a atividade:', error);
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
