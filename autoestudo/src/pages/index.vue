<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <v-toolbar-title>Auto Estudo</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text to="/">Cursos</v-btn>
      <v-btn text to="/users">Usuários</v-btn>
    </v-app-bar>

    <v-main>
      <router-view /> <!-- Renderiza a página correspondente à rota -->
    </v-main>
  </v-app>
</template>

<script setup>
  //
</script>
