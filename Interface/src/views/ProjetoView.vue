<template>
  <div class="container">
    <h1>Projetos</h1>
    <projeto-form @projeto-saved="fetchProjetos" />
    <projeto-list :projetos="projetos" @projeto-deleted="fetchProjetos" @fetch-atividades="fetchAtividadesByProjeto" />
  </div>
</template>

<script>
import ProjetoForm from '@/components/ProjetoForm.vue';
import ProjetoList from '@/components/ProjetoList.vue';
import projetoService from '@/services/projetoService';

export default {
  name: 'Projeto',
  components: {
    ProjetoForm,
    ProjetoList,
  },
  data() {
    return {
      projetos: [],
      atividades: [],
    };
  },
  created() {
    this.fetchProjetos();
  },
  methods: {
    async fetchProjetos() {
      try {
        const response = await projetoService.getAllProjetos();
        this.projetos = response.data;
      } catch (error) {
        console.error('Erro ao buscar projetos:', error);
      }
    },
    async fetchAtividadesByProjeto(projetoId) {
      try {
        const response = await projetoService.getAtividadesByProjeto(projetoId);
        this.atividades = response.data;
      } catch (error) {
        console.error('Erro ao buscar atividades do projeto:', error);
      }
    },
  },
};
</script>

<style scoped>
/* Estilo para ajustar o tamanho do campo "Status" no formulário de projetos */
.projeto-form input[name="status"] {
  width: 100%; /* Define o tamanho do campo como 100% */
}
</style>