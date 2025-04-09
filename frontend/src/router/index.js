/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import Courses from '@/pages/Courses.vue';
import Users from '@/pages/Users.vue';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  { path: '/', redirect: '/users' }, // Redireciona para a página de usuários por padrão
  { path: '/users', name: 'Users', component: Users },
  { path: '/courses', name: 'Courses', component: Courses },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
