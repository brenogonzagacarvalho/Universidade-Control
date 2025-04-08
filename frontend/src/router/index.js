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
  {
    path: '/',
    name: 'Courses',
    component: Courses, // Página de cursos
  },
  {
    path: '/users',
    name: 'Users',
    component: Users, // Página de usuários
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
