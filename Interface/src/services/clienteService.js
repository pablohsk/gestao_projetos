import axios from 'axios';

const API_URL = 'http://localhost:8080/clientes';

export default {
    getAllClientes() {
        return axios.get(API_URL);
    },

    createCliente(cliente) {
        return axios.post(API_URL, cliente, { headers: { 'Content-Type': 'application/json' } })
            .then(response => response.data)
            .catch(error => {
                console.error('Erro ao criar cliente no service:', error);
                throw error;
            });
    },
    updateCliente(id, cliente) {
        return axios.put(`${API_URL}/${id}`, cliente, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },

    deleteCliente(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
};
