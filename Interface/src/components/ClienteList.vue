<template>
  <div>
    <h2>Lista de Clientes</h2>
    <ul class="list-group">
      <li class="list-group-item d-flex justify-content-between align-items-center" v-for="cliente in clientes" :key="cliente.id">
        {{ cliente.nome }}
        <button class="btn btn-danger" @click="deleteCliente(cliente.id)">Deletar</button>
      </li>
    </ul>
  </div>
</template>

<script>
import clienteService from '@/services/clienteService'

export default {
  props: {
    clientes: Array
  },
  methods: {
    async deleteCliente(id) {
      try {
        await clienteService.deleteCliente(id)
        this.$emit('cliente-deleted')
      } catch (error) {
        console.error('Erro ao deletar cliente:', error)
      }
    }
  }
}
</script>

<style scoped>
</style>
