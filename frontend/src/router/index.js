/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import Courses from '@/pages/Courses.vue';
import Login from '@/pages/Login.vue'; // Certifique-se de que o caminho está correto
import Users from '@/pages/Users.vue';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  { path: '/', redirect: '/login' }, // Redireciona para a página de login por padrão
  { path: '/login', name: 'Login', component: Login }, // Rota para a página de login
  { path: '/users', name: 'Users', component: Users },
  { path: '/courses', name: 'Courses', component: Courses },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
