import axios from 'axios'

const API_URL = 'http://localhost:3000/clientes'

export default {
  getAllClientes() {
    return axios.get(API_URL)
  },

  createCliente(cliente) {
    return axios.post(API_URL, cliente)
  },

  deleteCliente(id) {
    return axios.delete(`${API_URL}/${id}`)
  }
}
