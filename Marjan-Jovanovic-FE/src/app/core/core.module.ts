import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpErrorInterceptorInterceptor } from './interceptors/http-error-interceptor.interceptor';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers:[
    {provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptorInterceptor, multi: true}
  ]
})
export class CoreModule { }
