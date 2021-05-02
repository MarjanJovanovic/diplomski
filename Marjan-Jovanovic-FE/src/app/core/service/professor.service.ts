import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Page } from '../models/page.dto';
import { ProfessorDto } from '../models/professor.model';

@Injectable({
  providedIn: 'root',
})
export class ProfessorService {
  controllerPrefix = 'professor';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<ProfessorDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'first_name') {
    return this.httpClient.get<Page<ProfessorDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(professor: ProfessorDto) {
    console.log(professor);

    const params = {
      id: professor.id,
      firstName: professor.firstName,
      lastName: professor.lastName,
      email: professor.email,
      address: professor.address,
      city: professor.city,

      phone: professor.phone,
      reelectionDate: professor.reelectionDate,
      title: professor.title,
      subjects: professor.subjects,
    };

    return this.httpClient.post<ProfessorDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      professor
    );
  }

  update(professor: ProfessorDto) {
    return this.httpClient.put<ProfessorDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      professor
    );
  }

  delete(professor: ProfessorDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${professor.id}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${professor.id}`,
      { responseType: 'text' }
    );
  }
}
