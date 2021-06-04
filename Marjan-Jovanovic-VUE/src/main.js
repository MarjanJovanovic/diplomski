import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";

// import {createApp} from 'vue';
// import App from './App.vue';
import PrimeVue from 'primevue/config';
// const app = createApp(App);

// app.use(PrimeVue);

createApp(App).use(store).use(router).use(PrimeVue).mount("#app");

export const apiClient = axios.create({
    // baseURL: 'http://localhost:8080/'
    baseURL: 'http://localhost:8090/eng-marjan-jovanovic/'        
})