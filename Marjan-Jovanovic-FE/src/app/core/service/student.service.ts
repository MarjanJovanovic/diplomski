import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Page } from '../models/page.dto';
import { StudentDto } from '../models/student.model';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  controllerPrefix = 'student';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<StudentDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'firstName') {
    return this.httpClient.get<Page<StudentDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(student: StudentDto) {
    console.log(student);

    const params = {
      id: student.id,
      firstName: student.firstName,
      lastName: student.lastName,
      email: student.email,
      address: student.address,
      city: student.city,

      indexNumber: student.indexNumber,
      currentYearOfStudy: student.currentYearOfStudy,
      indexYear: student.indexYear,
    };

    return this.httpClient.post<StudentDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      student
    );
  }

  update(student: StudentDto) {
    return this.httpClient.put<StudentDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      student
    );
  }

  delete(student: StudentDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${student.id}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${student.id}`,
      { responseType: 'text' }
    );
  }
}
