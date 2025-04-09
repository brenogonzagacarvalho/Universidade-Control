<template>
  <v-container>
    <v-row
      justify="center"
      class="mt-10"
    >
      <v-col
        cols="12"
        md="6"
      >
        <v-card>
          <v-card-title class="text-center">
            <h2>Login</h2>
          </v-card-title>
          <v-card-text>
            <v-form @submit.prevent="login">
              <v-text-field
                v-model="email"
                label="Email"
                outlined
                dense
                required
              />
              <v-text-field
                v-model="password"
                label="Senha"
                type="password"
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
                Entrar
              </v-btn>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import api from '@/plugins/axios';

const email = ref('');
const password = ref('');
const router = useRouter();

const login = async () => {
  try {
    await api.post('/auth/login', { email: email.value, password: password.value });
    alert('Login realizado com sucesso!');
    router.push('/users'); // Redireciona para a página inicial
  } catch {
    alert('Credenciais inválidas');
  }
};
</script>