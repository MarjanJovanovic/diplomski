import { createStore } from "vuex";

export default createStore({
  state: {
    cityList: null
  },
  getters:{
    getCityListState: (state) => {
      return state.cityList;
    }
  },
  mutations: {},
  actions: {},
  modules: {},
});
