import axios from 'axios'

export default class SubjectService {

    getAllSubjects(){
        return axios.get('')
    }

	getCarsSmall() {
		return axios.get('demo/data/cars-small.json').then(res => res.data.data);
	}

	getCarsMedium() {
		return axios.get('demo/data/cars-medium.json').then(res => res.data.data);
	}

	getCarsLarge() {
		return axios.get('demo/data/cars-large.json').then(res => res.data.data);
	}
}