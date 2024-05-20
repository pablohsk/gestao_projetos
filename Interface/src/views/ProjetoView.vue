<template>
  <div>
    <h1>Projetos</h1>
    <projeto-form @projeto-saved="fetchProjetos"/>
    <projeto-list :projetos="projetos" @projeto-deleted="fetchProjetos"/>
  </div>
</template>

<script>
import ProjetoForm from '@/components/ProjetoForm'
import ProjetoList from '@/components/ProjetoList'
import projetoService from '@/services/projetoService'

export default {
  name: 'Projeto',
  components: {
    ProjetoForm,
    ProjetoList
  },
  data() {
    return {
      projetos: []
    }
  },
  created() {
    this.fetchProjetos()
  },
  methods: {
    async fetchProjetos() {
      try {
        const response = await projetoService.getAllProjetos()
        this.projetos = response.data
      } catch (error) {
        console.error('Erro ao buscar projetos:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>