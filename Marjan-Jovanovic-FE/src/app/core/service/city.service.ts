import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CityDto } from '../models/city.model';
import { Page } from '../models/page.dto';

@Injectable({
  providedIn: 'root',
})
export class CityService {
  controllerPrefix = 'city';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<CityDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'name') {
    return this.httpClient.get<Page<CityDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(city: CityDto) {
    console.log(city);

    const params = {
      postalCode: city.postalCode,
      name: city.name,
    };

    return this.httpClient.post<CityDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      city
    );
  }

  update(city: CityDto) {
    return this.httpClient.put<CityDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      city
    );
  }

  delete(city: CityDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${city.postalCode}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${city.postalCode}`,
      { responseType: 'text' }
    );
  }
}
