<template>
  <div>
    <h1>Clientes</h1>
    <cliente-form @cliente-saved="fetchClientes"/>
    <cliente-list :clientes="clientes" @cliente-deleted="fetchClientes"/>
  </div>
</template>

<script>
import ClienteForm from '@/components/ClienteForm'
import ClienteList from '@/components/ClienteList'
import clienteService from '@/services/clienteService'

export default {
  name: 'Cliente',
  components: {
    ClienteForm,
    ClienteList
  },
  data() {
    return {
      clientes: []
    }
  },
  created() {
    this.fetchClientes()
  },
  methods: {
    async fetchClientes() {
      try {
        const response = await clienteService.getAllClientes()
        this.clientes = response.data
      } catch (error) {
        console.error('Erro ao buscar clientes:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>
