<template>
  <v-app>
    <v-app-bar 
      app 
      color="primary" 
      dark
    >
      <v-toolbar-title>Auto Estudo</v-toolbar-title>
      <v-spacer />
      <v-btn 
        text 
        to="/courses"
      >
        Cursos
      </v-btn>
      <v-btn 
        text 
        to="/users"
      >
        Usuários
      </v-btn>
      <v-btn 
        text 
        to="/"
      >
        Sair
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view /> <!-- Renderiza a página correspondente à rota -->
    </v-main>
  </v-app>
</template>

<script setup>
  //
</script>
