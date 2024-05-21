<template>
  <div class="container">
    <h1>Projetos</h1>
    <projeto-form :projeto="projetoParaEditar" @projeto-saved="fetchProjetos" />
    <projeto-list :projetos="projetos" @projeto-deleted="fetchProjetos" @edit-projeto="projetoParaEditar = $event" />
  </div>
</template>

<script>
import ProjetoForm from '@/components/ProjetoForm.vue';
import ProjetoList from '@/components/ProjetoList.vue';
import projetoService from '@/services/projetoService';

export default {
  name: 'ProjetoView',
  components: {
    ProjetoForm,
    ProjetoList,
  },
  data() {
    return {
      projetos: [],
      projetoParaEditar: null
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
        this.projetoParaEditar = null;
      } catch (error) {
        console.error('Erro ao buscar projetos:', error);
      }
    },
  },
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
