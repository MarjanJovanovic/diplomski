import { apiClient } from "../../main.js";

var controllerPrefix = "city/";

export default class {
  getAll() {
    return apiClient
      .get(controllerPrefix + "getAll")
      .then((data) => data.data)
      .catch((error) => {
        console.log(error);
      });
  }
  delete(cityCode) {
    return apiClient
      .delete(controllerPrefix + `delete${cityCode}`)
      // .then((data) => data.data)
      .catch((error) => {
        console.log(error);
      })
  }
}
