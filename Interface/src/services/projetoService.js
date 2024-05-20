import axios from 'axios'

const BASE_URL = 'http://localhost:8080/projetos'

export default {
  async getAllProjetos() {
    return axios.get(BASE_URL)
  },
  async createProjeto(projeto) {
    return axios.post(BASE_URL, projeto)
  },
  async updateProjeto(id, projeto) {
    return axios.put(`${BASE_URL}/${id}`, projeto)
  },
  async deleteProjeto(id) {
    return axios.delete(`${BASE_URL}/${id}`)
  }
}
