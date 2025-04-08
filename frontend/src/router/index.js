/**
 * router/index.ts
 *
 * Automatic routes for `./src/pages/*.vue`
 */

// Composables
import Courses from '@/pages/Courses.vue';
import Login from '@/pages/Login.vue';
import Users from '@/pages/Users.vue';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login, // Página de cursos
  },
  {
    path: '/users',
    name: 'Users',
    component: Users, // Página de usuários
  },
  {
    path: '/courses',
    name: 'Courses',
    component: Courses, // Página de login
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
