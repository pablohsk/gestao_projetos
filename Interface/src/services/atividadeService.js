import axios from 'axios'

const BASE_URL = 'http://localhost:8080/atividades'

export default {
  async getAllAtividades() {
    return axios.get(BASE_URL)
  },
  async createAtividade(atividade) {
    return axios.post(BASE_URL, atividade)
  },
  async updateAtividade(id, atividade) {
    return axios.put(`${BASE_URL}/${id}`, atividade)
},
async deleteAtividade(id) {
return axios.delete(`${BASE_URL}/${id}`)
}
}
