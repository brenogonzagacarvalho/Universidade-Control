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
          Gerenciamento de Cursos
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
            <span>{{ isEditing ? "Editar Curso" : "Adicionar Novo Curso" }}</span>
          </v-card-title>
          <v-card-text>
            <v-form @submit.prevent="isEditing ? updateCourse() : saveCourse()">
              <v-text-field
                v-model="course.name"
                label="Nome"
                outlined
                dense
                required
              />
              <v-text-field
                v-model="course.acronym"
                label="Sigla"
                outlined
                dense
                required
              />
              <v-select
                v-model="course.shift"
                :items="shifts"
                label="Turno"
                outlined
                dense
                required
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
            <span>Lista de Cursos</span>
          </v-card-title>
          <v-card-text>
            <v-list>
              <v-list-item
                v-for="course in courses"
                :key="course.id"
                class="d-flex justify-space-between"
              >
                <div>
                  <strong>{{ course.name }}</strong> - {{ course.acronym }} -
                  {{ course.shift }}
                </div>
                <div>
                  <v-btn
                    color="primary"
                    text
                    @click="editCourse(course)"
                  >
                    Editar
                  </v-btn>
                  <v-btn
                    color="error"
                    text
                    class="ml-2"
                    @click="deleteCourse(course.id)"
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

const courses = ref([]);
const course = ref({ name: '', acronym: '', shift: 'manhã' });
const shifts = ['manhã', 'tarde', 'noite'];
const isEditing = ref(false);

const fetchCourses = async () => {
  const { data } = await api.get('/courses');
  courses.value = data;
};

const saveCourse = async () => {
  await api.post('/courses', course.value);
  resetForm();
  fetchCourses();
};

const editCourse = (selectedCourse) => {
  course.value = { ...selectedCourse }; // Preenche o formulário com os dados do curso
  isEditing.value = true;
};

const updateCourse = async () => {
  try {
    console.log("Dados enviados para a API:", course.value);
    const response = await api.put(`/courses/${course.value.id}`, course.value);
    console.log("Resposta da API:", response);
    resetForm();
    fetchCourses();
  } catch (error) {
    console.error("Erro ao atualizar o curso:", error);
    if (error.response) {
      console.error("Resposta da API:", error.response.data);
    }
  }
};

const deleteCourse = async (id) => {
  await api.delete(`/courses/${id}`);
  fetchCourses();
};

const cancelEdit = () => {
  resetForm();
};

const resetForm = () => {
  course.value = { name: '', acronym: '', shift: 'manhã' }; // Limpa o formulário
  isEditing.value = false;
};

onMounted(fetchCourses);
</script>
