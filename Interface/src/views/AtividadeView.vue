<template>
  <div class="container">
    <h1>Atividades</h1>
    <atividade-form :atividade="atividadeParaEditar" @atividade-saved="fetchAtividades" />
    <atividade-list :atividades="atividades" @atividade-deleted="fetchAtividades" @edit-atividade="setAtividadeParaEditar" />
  </div>
</template>

<script>
import AtividadeForm from '@/components/AtividadeForm.vue';
import AtividadeList from '@/components/AtividadeList.vue';
import atividadeService from '@/services/atividadeService';

export default {
  name: 'AtividadeView',
  components: {
    AtividadeForm,
    AtividadeList,
  },
  data() {
    return {
      atividades: [],
      atividadeParaEditar: null
    };
  },
  created() {
    this.fetchAtividades();
  },
  methods: {
    async fetchAtividades() {
      try {
        const response = await atividadeService.getAllAtividades();
        this.atividades = response.data;
        this.atividadeParaEditar = null;
      } catch (error) {
        console.error('Erro ao buscar atividades:', error);
      }
    },
    setAtividadeParaEditar(atividade) {
      this.atividadeParaEditar = atividade;
    }
  }
};
</script>

<style scoped>
.container {
  padding: 2rem;
  background-color: white;
  margin-top: 1rem;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
</style>
