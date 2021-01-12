import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'


Vue.config.productionTip = false

Vue.use(require('vue-moment'))
require('@/assets/style.css')

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
