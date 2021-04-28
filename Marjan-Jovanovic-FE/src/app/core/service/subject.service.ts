import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Subject } from '../models/subject.model';
import { environment } from 'src/environments/environment';
import { Page } from '../models/page.dto';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  controllerPrefix = 'subject';

  constructor(private httpClient: HttpClient) { }

  getAll(){
    return this.httpClient.get<Subject[]>(`${environment.baseHttpURL}/${this.controllerPrefix}/getAll`)
  }

  getByPage(page:number, size: number) {
    return this.httpClient.get<Page<Subject[]>>(`${environment.baseHttpURL}/${this.controllerPrefix}/page?page=${page}&size=${size}`)
  }

}
