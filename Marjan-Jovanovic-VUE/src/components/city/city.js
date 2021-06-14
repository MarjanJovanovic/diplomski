// import CityService from "../services/CityService";

// export default {
//     data() {
//         return {
//             cities: null
//         }
//     },
//     cityService: null,
//     created() {
//         this.cityService = new CityService();
//     },
//     mounted() {
//         this.cityService.getAll().then(data => this.cities = data);
//     }
// }
import { createApp } from "vue";
import App from "./index.vue";
import PrimeVue from "primevue/config";

import { ref, onMounted } from "vue";
import CityService from "../services/CityService";

const app = createApp(App);
// app.mount('#app') // ?
app.use(PrimeVue);

export default {
  setup() {
    onMounted(() => {
      console.log("onMounted function");
      cityService.value.getAll().then((data) => (cities.value = data));
    });

    const cities = ref();
    const cityService = ref(new CityService());

    return { cities, cityService };
  },
  // name: 'city',
  // components: {},
  // props: [],w

  // computed: {

  // },
  // mounted () {

  // },
  // methods: {

  // }
};
