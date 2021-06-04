import { apiClient }  from '../../main.js';

var controllerPrefix = 'city/';
  
  export default class{

    getAll(){
      console.log(apiClient.get(controllerPrefix + 'getAll'));
      return apiClient.get(controllerPrefix + 'getAll')
      .then(({data}) => {
        console.log(data);
      })
      .catch((error) => {
        console.log(error);
      });
    }

  }