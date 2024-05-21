import axios from 'axios';

const API_URL = 'http://localhost:8080/atividades';

export default {
    getAllAtividades() {
        return axios.get(API_URL);
    },
    createAtividade(atividade) {
        return axios.post(API_URL, atividade, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.data)
            .catch(error => {
                console.error('Erro ao criar atividade no serviço:', error);
                throw error;
            });
    },
    deleteAtividade(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};
