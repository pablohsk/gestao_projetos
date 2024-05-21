<template>
  <div id="app">
    <nav class="navbar">
      <div class="navbar-links">
        <a @click="goTo('/')">Home</a>
        <a @click="goTo('/clientes')">Clientes</a>
        <a @click="goTo('/projetos')">Projetos</a>
        <a @click="goTo('/atividades')">Atividades</a>
      </div>
    </nav>
    <div class="container">
      <router-view />
    </div>
    <footer class="footer">
      <div class="footer-content">
        <p>Desenvolvido por Pablo Fidelis Dias</p>
        <div class="social-links">
          <a href="https://www.linkedin.com/in/pablofideliss/" target="_blank" rel="noopener noreferrer">
            <img src="@/assets/img/ln.jpg" alt="LinkedIn">
          </a>
          <a href="https://github.com/pablohsk/" target="_blank" rel="noopener noreferrer">
            <img src="@/assets/img/gh.png" alt="GitHub">
          </a>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    goTo(route) {
      if (this.$route.path !== route) {
        this.$router.push(route);
      }
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
  background-image: url('https://source.unsplash.com/featured/?nature,water');
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
}

.navbar {
  background-color: #2e8eef;
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.navbar-links {
  display: flex;
  gap: 1rem;
}

.navbar a {
  color: white;
  text-decoration: none;
  padding: 0.5rem 1rem;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.navbar a:hover {
  background-color: #1e6fb9;
}

.container {
  padding: 2rem;
  background-color: white;
  margin-top: 1rem;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.footer {
  background-color: rgba(46, 142, 239, 0.7);
  color: #fff;
  padding: 1rem 0;
  width: 100%;
  position: fixed;
  bottom: 0;
}

.footer-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
}

.social-links {
  display: flex;
  gap: 1rem;
}

.social-links a {
  color: #fff;
}

.social-links img {
  width: 40px;
  height: auto;
}

h1 {
  color: #2e8eef;
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

p {
  color: #aa9d9d;
  font-size: 1rem;
}
</style>