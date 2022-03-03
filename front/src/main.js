import { createApp } from 'vue'
import App from './App.vue'
import router from './router/main';
import MdiSvg from '@yeliulee/vue-mdi-svg/v3'
import store from "./store/main";
import PrimeVue from 'primevue/config';


createApp(App).use(store).use(router).use(MdiSvg).use(PrimeVue).mount('#app')
