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
        });
    },

    updateProjeto(id, projeto) {
        return axios.put(`${API_URL}/${id}`, projeto, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },

    deleteProjeto(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};
