<template>
  <div class="home-content">
    <h1>Bem-Vindo ao sistema de Gestão de Projetos</h1>
    <p>Use o menu acima para acessar a Clientes, Projetos e Atividades.</p>
  </div>
</template>

<script>
export default {
  name: 'Home'
};
</script>

<style scoped>
.home-content {
  text-align: center;
  color: #514f4f;
  padding: 2rem;
  background-size: cover; /* Ajusta o tamanho da imagem para cobrir todo o conteúdo */
  background-position: center; /* Centraliza a imagem */
  height: 100vh; /* Define a altura para ocupar toda a tela */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.footer {
  background-color: #2e8eef; /* Mesma cor do menu superior */
  color: #fff; /* Cor do texto do rodapé */
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
  width: 30px;
  height: auto;
}

h1 {
  font-size: 3rem;
  margin-bottom: 1rem;
  font-family: 'Arial', sans-serif;
}

p {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  font-family: 'Arial', sans-serif;
}
</style>
