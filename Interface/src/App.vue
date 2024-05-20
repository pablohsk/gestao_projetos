<template>
  <div id="app">
    <nav class="navbar">
      <router-link to="/">Home</router-link>
      <router-link to="/clientes">Clientes</router-link>
      <router-link to="/projetos">Projetos</router-link>
      <router-link to="/atividades">Atividades</router-link>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
body {
  font-family: 'Arial', sans-serif;
  background-color: #f0f4f8;
  margin: 0;
  padding: 0;
}

.navbar {
  background-color: #004d99;
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
  background-color: #003366;
}

.container {
  padding: 2rem;
}

.card {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 2rem;
  margin-bottom: 2rem;
}

h1 {
  color: #004d99;
  font-size: 2rem;
  margin-bottom: 1rem;
}

p {
  color: #333;
  font-size: 1rem;
}
</style>
