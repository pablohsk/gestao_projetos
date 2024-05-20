import axios from 'axios'

const BASE_URL = 'http://localhost:8080/clientes'

export default {
  async getAllClientes() {
    return axios.get(BASE_URL)
  },
  async createCliente(cliente) {
    return axios.post(BASE_URL, cliente)
  },
  async updateCliente(id, cliente) {
    return axios.put(`${BASE_URL}/${id}`, cliente)
  },
  async deleteCliente(id) {
    return axios.delete(`${BASE_URL}/${id}`)
  }
}
