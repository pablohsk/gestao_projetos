import Vue from 'vue'
import Router from 'vue-router'
import AtividadeList from '@/components/AtividadeList'
import AtividadeForm from '@/components/AtividadeForm'
import ClienteList from '@/components/ClienteList'
import ClienteForm from '@/components/ClienteForm'
import ProjetoList from '@/components/ProjetoList'
import ProjetoForm from '@/components/ProjetoForm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/atividades'
    },
    {
      path: '/atividades',
      name: 'AtividadeList',
      component: AtividadeList
    },
    {
      path: '/atividades/novo',
      name: 'NovaAtividade',
      component: AtividadeForm
    },
    {
      path: '/clientes',
      name: 'ClienteList',
      component: ClienteList
    },
    {
      path: '/clientes/novo',
      name: 'NovoCliente',
      component: ClienteForm
    },
    {
      path: '/projetos',
      name: 'ProjetoList',
      component: ProjetoList
    },
    {
      path: '/projetos/novo',
      name: 'NovoProjeto',
      component: ProjetoForm
    }
  ]
})
