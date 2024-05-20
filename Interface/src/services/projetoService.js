import axios from 'axios'

const API_URL = 'http://localhost:3000/projetos'

export default {
  getAllProjetos() {
    return axios.get(API_URL)
  },

  createProjeto(projeto) {
    return axios.post(API_URL, projeto)
  },

  deleteProjeto(id) {
    return axios.delete(`${API_URL}/${id}`)
  }
}
