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
        });
    },
    updateAtividade(id, atividade) {
        return axios.put(`${API_URL}/${id}`, atividade, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },
    deleteAtividade(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};
