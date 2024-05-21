<template>
  <div>
    <h2>Lista de Clientes</h2>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Nome</th>
        <th class="text-right">Ações</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="cliente in clientes" :key="cliente.id">
        <td>{{ cliente.nome }}</td>
        <td class="text-right">
          <button class="btn btn-danger" @click="deleteCliente(cliente.id)">Deletar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import clienteService from '@/services/clienteService';

export default {
  props: {
    clientes: Array
  },
  methods: {
    async deleteCliente(id) {
      try {
        await clienteService.deleteCliente(id);
        this.$emit('cliente-deleted');
      } catch (error) {
        console.error('Erro ao deletar cliente:', error);
      }
    }
  }
};
</script>

<style scoped>
.table {
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.table th, .table td {
  border: none;
  padding: 15px;
  vertical-align: middle;
}

.table th {
  background-color: #007bff;
  color: white;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: #e9ecef;
}

.text-right {
  text-align: right;
}
</style>
