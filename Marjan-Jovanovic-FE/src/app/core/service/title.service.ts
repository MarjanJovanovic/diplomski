import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TitleDto } from '../models/title.model';

@Injectable({
  providedIn: 'root'
})
export class TitleService {
  controllerPrefix = 'title';

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<TitleDto[]>(
      `${environment.baseHttpURL}/${this.controllerPrefix}/getAll`
    );
  }

}
