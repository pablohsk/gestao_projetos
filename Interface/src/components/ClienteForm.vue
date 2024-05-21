<template>
  <div class="mb-4">
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" v-model="nome" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">{{ isEdit ? 'Atualizar' : 'Salvar' }}</button>
    </form>
  </div>
</template>

<script>
import clienteService from '@/services/clienteService';

export default {
  props: {
    cliente: Object
  },
  data() {
    return {
      nome: '',
      isEdit: false
    }
  },
  watch: {
    cliente: {
      immediate: true,
      handler(newVal) {
        if (newVal) {
          this.nome = newVal.nome;
          this.isEdit = true;
        } else {
          this.nome = '';
          this.isEdit = false;
        }
      }
    }
  },
  methods: {
    async handleSubmit() {
      try {
        if (this.nome !== undefined && this.nome !== '') {
          if (this.isEdit) {
            await clienteService.updateCliente(this.cliente.id, { nome: this.nome });
          } else {
            await clienteService.createCliente({ nome: this.nome });
          }
          this.nome = '';
          this.isEdit = false;
          this.$emit('cliente-saved');
        } else {
          console.error('Erro ao salvar cliente: nome não preenchido');
        }
      } catch (error) {
        console.error('Erro ao salvar cliente:', error);
      }
    }
  }
}
</script>

<style scoped>
</style>
