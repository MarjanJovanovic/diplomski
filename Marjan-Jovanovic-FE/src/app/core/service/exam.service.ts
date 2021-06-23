import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ExamDto } from '../models/exam.model';
import { Page } from '../models/page.dto';

@Injectable({
  providedIn: 'root',
})
export class ExamService {
  controllerPrefix = 'exam';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<ExamDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'name') {
    return this.httpClient.get<Page<ExamDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(exam: ExamDto) {
    console.log(exam);

    const params = {
      // id: exam.id,
      date: exam.date,
      examPeriod: exam.examPeriod,
      professor: exam.professor,
      subject: exam.subject,
    };

    return this.httpClient.post<ExamDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      exam
    );
  }

  update(exam: ExamDto) {
    return this.httpClient.put<ExamDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      exam
    );
  }

  delete(exam: ExamDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${exam.id}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${exam.id}`,
      { responseType: 'text' }
    );
  }
}
