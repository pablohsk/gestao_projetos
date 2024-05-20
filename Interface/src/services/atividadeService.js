import axios from 'axios'

const API_URL = 'http://localhost:3000/atividades'

export default {
  getAllAtividades() {
    return axios.get(API_URL)
  },
  createAtividade(atividade) {
    return axios.post(API_URL, atividade)
  },
  deleteAtividade(id) {
    return axios.delete(`${API_URL}/${id}`)
  }
}