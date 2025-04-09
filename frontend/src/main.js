/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Plugins
import { registerPlugins } from '@/plugins';

// Components
import App from './App.vue';

// Composables
import { createApp } from 'vue';

// Router
import router from './router'; // Importa o router

const app = createApp(App)

registerPlugins(app)

app.use(router); // Usa o router
app.mount('#app')
