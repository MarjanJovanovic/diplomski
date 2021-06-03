import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

// import {createApp} from 'vue';
// import App from './App.vue';
import PrimeVue from 'primevue/config';
// const app = createApp(App);

// app.use(PrimeVue);

createApp(App).use(store).use(router).use(PrimeVue).mount("#app");
