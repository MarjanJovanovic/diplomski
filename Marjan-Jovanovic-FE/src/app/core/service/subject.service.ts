import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubjectDto } from '../models/subject.model';
import { environment } from 'src/environments/environment';
import { Page } from '../models/page.dto';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class SubjectService {
  controllerPrefix = 'subject';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<SubjectDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'name') {
    return this.httpClient.get<Page<SubjectDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(subject: SubjectDto) {
    console.log(subject);

    const params = {
      name: subject.name,
      description: subject.description,
      noOfEsp: subject.noOfEsp,
      yearOfStudy: subject.yearOfStudy,
      semester: subject.semester,
    };

    return this.httpClient.post<SubjectDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      subject
    );
  }

  update(subject: SubjectDto) {
    return this.httpClient.put<SubjectDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      subject
    );
  }

  delete(subject: SubjectDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${subject.id}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${subject.id}`,
      { responseType: 'text' }
    );
  }
}
