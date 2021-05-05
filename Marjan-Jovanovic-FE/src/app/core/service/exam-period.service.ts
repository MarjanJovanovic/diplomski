import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ExamPeriodDto } from '../models/exam-period.model';
import { Page } from '../models/page.dto';

@Injectable({
  providedIn: 'root',
})
export class ExamPeriodService {
  controllerPrefix = 'examPeriod';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<ExamPeriodDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

  getByPage(page: number, size: number, sortBy: string = 'name') {
    return this.httpClient.get<Page<ExamPeriodDto[]>>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAllFiltered?page=${page}&size=${size}`
    );
  }

  save(examPeriod: ExamPeriodDto) {
    console.log(examPeriod);

    const params = {
      id: examPeriod.id,
      name: examPeriod.name,
      startDate: examPeriod.startDate,
      endDate: examPeriod.endDate,
      isActive: examPeriod.isActive,
    };

    return this.httpClient.post<ExamPeriodDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/save`,
      examPeriod
    );
  }

  update(examPeriod: ExamPeriodDto) {
    return this.httpClient.put<ExamPeriodDto>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/update`,
      examPeriod
    );
  }

  delete(examPeriod: ExamPeriodDto) {
    console.log(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${examPeriod.id}`
    );
    return this.httpClient.delete(
      `${environment.baseHttpURL}/${this.controllerPrefix}/${examPeriod.id}`,
      { responseType: 'text' }
    );
  }
}
