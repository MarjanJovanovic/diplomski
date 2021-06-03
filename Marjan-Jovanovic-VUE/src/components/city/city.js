import {createApp} from 'vue';
import App from './index.vue';
import PrimeVue from 'primevue/config';
import Dialog from 'primevue/dialog';

// import DataTable from 'primevue/datatable';
// import Column from 'primevue/column';
// import ColumnGroup from 'primevue/columngroup';     //optional for column grouping

// import axios from 'axios'

const app = createApp(App);

app.use(PrimeVue);

app.component('Dialog', Dialog);

export default {
  name: 'city',
  components: {},
  props: [],
  data () {
    return {

    }
  },
  computed: {

  },
  mounted () {

  },
  methods: {

  }
}


