import Vue from 'vue'
import App from './App.vue'
import router from './router'; // Verifique se você importou o Vue Router aqui

Vue.config.productionTip = false

new Vue({
  router, // Verifique se você está usando o Vue Router aqui
  render: h => h(App),
}).$mount('#app')