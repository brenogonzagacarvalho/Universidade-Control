<template>
  <v-container>
    <v-row
      justify="center"
      class="mb-4"
    >
      <v-col
        cols="12"
        md="8"
      >
        <h1 class="text-center">
          Gerenciamento de Usuários
        </h1>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-col
        cols="12"
        md="8"
      >
        <v-card>
          <v-card-title>
            <span>{{ isEditing ? "Editar Usuário" : "Adicionar Novo Usuário" }}</span>
          </v-card-title>
          <v-card-text>
            <v-form @submit.prevent="isEditing ? updateUser() : saveUser()">
              <v-text-field
                v-model="user.name"
                label="Nome"
                outlined
                dense
                required
              />
              <v-text-field
                v-model="user.email"
                label="Email"
                outlined
                dense
                required
              />
              <v-text-field
                v-model="user.password"
                label="Senha"
                type="password"
                outlined
                dense
                required
              />
              <v-checkbox
                v-model="user.active"
                label="Ativo"
                dense
              />
              <v-btn
                type="submit"
                color="primary"
                block
                class="mt-4"
              >
                {{ isEditing ? "Atualizar" : "Salvar" }}
              </v-btn>
              <v-btn
                v-if="isEditing"
                color="secondary"
                block
                class="mt-2"
                @click="cancelEdit"
              >
                Cancelar
              </v-btn>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>

    <v-row
      justify="center"
      class="mt-4"
    >
      <v-col
        cols="12"
        md="8"
      >
        <v-card>
          <v-card-title>
            <span>Lista de Usuários</span>
          </v-card-title>
          <v-card-text>
            <v-list>
              <v-list-item
                v-for="user in users"
                :key="user.id"
                class="d-flex justify-space-between"
              >
                <div>
                  <strong>{{ user.name }}</strong> - {{ user.email }} - 
                  <span>{{ user.active ? "Ativo" : "Inativo" }}</span>
                </div>
                <div>
                  <v-btn
                    color="primary"
                    text
                    @click="editUser(user)"
                  >
                    Editar
                  </v-btn>
                  <v-btn
                    color="error"
                    text
                    :disabled="user.active"
                    @click="deleteUser(user.id)"
                  >
                    Excluir
                  </v-btn>
                </div>
              </v-list-item>
            </v-list>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import api from '@/plugins/axios';
import { onMounted, ref } from 'vue';

const users = ref([]);
const user = ref({ name: '', email: '', password: '', active: false });
const isEditing = ref(false);

const fetchUsers = async () => {
  const { data } = await api.get('/users');
  users.value = data;
};

const saveUser = async () => {
  await api.post('/users', user.value);
  resetForm();
  fetchUsers();
};

const editUser = (selectedUser) => {
  user.value = { ...selectedUser }; // Preenche o formulário com os dados do usuário
  isEditing.value = true;
};

const updateUser = async () => {
  await api.put(`/users/${user.value.id}`, user.value); // Atualiza o usuário no backend

  // Atualiza o item na lista de usuários
  const index = users.value.findIndex((u) => u.id === user.value.id);
  if (index !== -1) {
    users.value[index] = { ...user.value };
  }

  resetForm();
};

const deleteUser = async (id) => {
  await api.delete(`/users/${id}`);
  fetchUsers();
};

const cancelEdit = () => {
  resetForm();
};

const resetForm = () => {
  user.value = { name: '', email: '', password: '', active: false }; // Limpa o formulário
  isEditing.value = false;
};

onMounted(fetchUsers);
</script>