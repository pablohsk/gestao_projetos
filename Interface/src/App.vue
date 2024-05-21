<template>
  <div id="app">
    <nav class="navbar">
      <a @click="goTo('/')">Home</a>
      <a @click="goTo('/clientes')">Clientes</a>
      <a @click="goTo('/projetos')">Projetos</a>
      <a @click="goTo('/atividades')">Atividades</a>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    goTo(route) {
      this.$router.push(route);
    }
  }
}
</script>

<style>

body {
  font-family: 'Arial', sans-serif;
  background-color: #f0f4f8;
  margin: 0;
  padding: 0;
}

.navbar {
  background-color: #2e8eef;
  padding: 1rem;
  display: flex;
  justify-content: space-around;
}

.navbar a {
  color: white;
  text-decoration: none;
  padding: 0.5rem 1rem;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.navbar a:hover {
  background-color: #7c96a8;
}

.container {
  padding: 2rem;
}

h1 {
  color: #89a1b6;
  font-size: 2rem;
  margin-bottom: 1rem;
}

p {
  color: #8390d6;
  font-size: 1rem;
}
</style>
