import {createApp} from 'vue';
import App from './index.vue';
import PrimeVue from 'primevue/config';

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
  name: 'city',
  components: {},
  props: [],

  computed: {

  },
  mounted () {

  },
  methods: {

  }
}


