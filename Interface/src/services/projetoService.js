import axios from 'axios';

const API_URL = 'http://localhost:8080/projetos';

export default {
  getAllProjetos() {
    return axios.get(API_URL);
  },
  createProjeto(projeto) {
    return axios.post(API_URL, projeto, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
        .then(response => response.data)
        .catch(error => {
          console.error('Erro ao criar projeto no serviço:', error);
          throw error;
        });
  },
  deleteProjeto(id) {
    return axios.delete(`${API_URL}/${id}`);
  },
  getAtividadesByProjeto(id) {
    return axios.get(`${API_URL}/${id}/atividades`);
  },
};
