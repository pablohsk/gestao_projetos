<template>
  <div class="container">
    <h1>Clientes</h1>
    <cliente-form :cliente="clienteParaEditar" @cliente-saved="fetchClientes" />
    <cliente-list :clientes="clientes" @cliente-deleted="fetchClientes" @edit-cliente="clienteParaEditar = $event" />
  </div>
</template>

<script>
import ClienteForm from '@/components/ClienteForm.vue';
import ClienteList from '@/components/ClienteList.vue';
import clienteService from '@/services/clienteService';

export default {
  name: 'ClienteView',
  components: {
    ClienteForm,
    ClienteList,
  },
  data() {
    return {
      clientes: [],
      clienteParaEditar: null
    };
  },
  created() {
    this.fetchClientes();
  },
  methods: {
    async fetchClientes() {
      try {
        const response = await clienteService.getAllClientes();
        this.clientes = response.data;
        this.clienteParaEditar = null;
      } catch (error) {
        console.error('Erro ao buscar clientes:', error);
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
