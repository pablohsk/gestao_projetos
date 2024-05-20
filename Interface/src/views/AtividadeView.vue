<template>
  <div class="container">
    <h1>Atividades</h1>
    <atividade-form @atividade-saved="fetchAtividades"/>
    <atividade-list :atividades="atividades" @atividade-deleted="fetchAtividades"/>
  </div>
</template>

<script>
import AtividadeForm from '@/components/AtividadeForm'
import AtividadeList from '@/components/AtividadeList'
import atividadeService from '@/services/atividadeService'

export default {
  name: 'Atividade',
  components: {
    AtividadeForm,
    AtividadeList
  },
  data() {
    return {
      atividades: []
    }
  },
  created() {
    this.fetchAtividades()
  },
  methods: {
    async fetchAtividades() {
      try {
        const response = await atividadeService.getAllAtividades()
        this.atividades = response.data
      } catch (error) {
        console.error('Erro ao buscar atividades:', error)
      }
    }
  }
}
</script>

<style scoped>
h1 {
  color: #007bff;
}
</style>