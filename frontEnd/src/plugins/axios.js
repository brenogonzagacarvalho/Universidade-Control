import axios from 'axios';

const api = axios.create({
  baseURL: '/api', // Use o proxy configurado no Vite
});

export default api;