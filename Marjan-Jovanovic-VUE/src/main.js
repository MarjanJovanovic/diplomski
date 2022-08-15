// import "primeflex/primeflex.css";
import "primevue/resources/themes/saga-blue/theme.css";
import "primevue/resources/primevue.min.css";
import "primeicons/primeicons.css";
// import "./index.css";

import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";
import Column from "primevue/column";
import DataTable from "primevue/datatable";
import Button from 'primevue/button';

import PrimeVue from "primevue/config";

const app = createApp(App);

app.use(store);
app.use(router);
app.use(PrimeVue, { ripple: true });

app.component("Column", Column);
app.component("DataTable", DataTable);
app.component('Button', Button);

app.mount("#app");

export const apiClient = axios.create({
  // baseURL: 'http://localhost:8080/'
  baseURL: "http://localhost:8090/eng-marjan-jovanovic/",
});
