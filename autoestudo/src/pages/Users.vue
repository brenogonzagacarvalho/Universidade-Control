<template>
  <div>
    <h1>Gerenciamento de Usuários</h1>
    <form @submit.prevent="saveUser">
      <input v-model="user.name" placeholder="Nome" required />
      <input v-model="user.email" placeholder="Email" required />
      <input v-model="user.password" type="password" placeholder="Senha" required />
      <label>
        <input v-model="user.active" type="checkbox" />
        Ativo
      </label>
      <button type="submit">Salvar</button>
    </form>

    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.name }} - {{ user.email }}
        <button @click="deleteUser(user.id)" :disabled="user.active">Excluir</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import api from '@/plugins/axios';

const users = ref([]);
const user = ref({ name: '', email: '', password: '', active: false });

const fetchUsers = async () => {
  const { data } = await api.get('/users');
  users.value = data;
};

const saveUser = async () => {
  await api.post('/users', user.value);
  fetchUsers();
};

const deleteUser = async (id) => {
  await api.delete(`/users/${id}`);
  fetchUsers();
};

onMounted(fetchUsers);
</script>