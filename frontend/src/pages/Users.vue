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
        <h1 
          class="text-center"
        >
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
          <v-card-title class="d-flex justify-center">
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
                :rules="[nameRule]"                
              />
              <v-text-field
                v-model="user.email"
                label="Email"
                outlined
                dense
                required
                :rules="[emailRule]"
              />
              <v-text-field
                v-model="user.password"
                label="Senha"
                type="password"
                outlined
                dense
                required
                :rules="[passwordRule]"
              />
              <v-checkbox
                v-model="user.active"
                label="Ativo"
                dense
              />
              <v-select
                v-model="user.courseId"
                :items="courses"
                item-title="name"
                item-value="id"
                label="Curso"
                outlined
                dense
                required
                :rules="[courseRule]"
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
                  <span>{{ user.active ? "Ativo" : "Inativo" }}</span> - 
                  <span>{{ user.course ? user.course.name : "Sem curso" }}</span>
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
                    class="ml-2"
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
const courses = ref([]);
const user = ref({ name: '', email: '', password: '', active: false, courseId: null });

const isEditing = ref(false);

const nameRule = (value) => !!value || "O nome é obrigatório";
const emailRule = (value) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(value) || "Por favor, insira um email válido";
};
const passwordRule = (value) => value.length >= 6 || "A senha deve ter pelo menos 6 caracteres";
const courseRule = (value) => !!value || "Selecione um curso";

const fetchUsers = async () => {
  const { data } = await api.get('/users');
  users.value = data;
};

const fetchCourses = async () => {
  const { data } = await api.get('/courses');
  courses.value = data.map(course => ({
    id: course.id,  
    name: course.name
  }));  
};

const saveUser = async () => {
  try {
    // Validações dos campos obrigatórios
    if (!user.value.name || !user.value.email || !user.value.password || !user.value.courseId) {
      alert("Por favor, preencha todos os campos obrigatórios.");
      return;
    }

    const userToSave = { 
      ...user.value, 
      courseId: { id: user.value.courseId } // Envia o curso como um objeto com o ID
    };

    console.log("Dados enviados para a API:", userToSave);

    // Faz a requisição para salvar o usuário
    const response = await api.post('/users', userToSave);

    console.log("Resposta da API:", response);

    // Atualiza a lista de usuários
    fetchUsers();

    // Reseta o formulário
    resetForm();
  } catch (error) {
    console.error("Erro ao salvar o usuário:", error);
    if (error.response) {
      console.error("Resposta da API:", error.response.data);
    }
  }
};

const editUser = (selectedUser) => {
  try {
    // Preenche o formulário com os dados do usuário selecionado
    user.value = { 
      ...selectedUser, 
      courseId: selectedUser.course ? selectedUser.course.id : null 
    };
    isEditing.value = true;
  } catch (error) {
    console.error("Erro ao editar o usuário:", error);
  }
};

const updateUser = async () => {
  try {
    // Validações dos campos obrigatórios
    if (!user.value.name || !user.value.email || !user.value.password || !user.value.courseId) {
      alert("Por favor, preencha todos os campos obrigatórios.");
      return;
    }

    const userToUpdate = { 
      ...user.value, 
      courseId: { id: user.value.courseId } // Envia o curso como um objeto com o ID
    };

    console.log("Dados enviados para a API:", userToUpdate);

    // Faz a requisição de atualização
    await api.put(`/users/${user.value.id}`, userToUpdate);

    // Atualiza o usuário na lista local
    const index = users.value.findIndex((u) => u.id === user.value.id);
    if (index !== -1) {
      users.value[index] = { 
        ...user.value, 
        course: courses.value.find(course => course.id === user.value.courseId) // Atualiza o curso completo
      };
    }

    // Reseta o formulário
    resetForm();
  } catch (error) {
    console.error("Erro ao atualizar o usuário:", error);
    if (error.response) {
      console.error("Resposta da API:", error.response.data);
    }
  }
};

const deleteUser = async (id) => {
  try {
    // Faz a requisição para deletar o usuário
    await api.delete(`/users/${id}`);

    // Atualiza a lista de usuários
    fetchUsers();
  } catch (error) {
    console.error("Erro ao excluir o usuário:", error);
  }
};

const cancelEdit = () => {
  resetForm();
};

const resetForm = () => {
  user.value = { name: '', email: '', password: '', active: false, courseId: null };
  isEditing.value = false;
};

onMounted(() => {
  fetchUsers();
  fetchCourses();
});
</script>
