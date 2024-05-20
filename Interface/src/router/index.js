import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/views/HomeView.vue';
import Cliente from '@/views/ClienteView.vue';
import ProjetoView from "@/views/ProjetoView.vue";
import Atividade from '@/views/AtividadeView.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/clientes',
      name: 'clientes',
      component: Cliente
    },
    {
      path: '/projetos',
      name: 'projetos',
      component: ProjetoView
    },
    {
      path: '/atividades',
      name: 'atividades',
      component: Atividade
    }
  ]
});
