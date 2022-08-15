import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable()
export class HttpErrorInterceptorInterceptor implements HttpInterceptor {
  constructor(private snackBar: MatSnackBar) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(
      tap((e) => {
        if (request.method == 'POST' || request.method == 'PUT')
          if (e instanceof HttpResponse && e.status == 200) {
            this.snackBar.open('Saved successfully.', 'close', {
              duration: 2000,
              panelClass: 'successSnack',
            });
          }

        if (request.method == 'DELETE' )
          if (e instanceof HttpResponse && e.status == 200) {
            this.snackBar.open('Deleted successfully.', 'close', {
              duration: 2000,
              panelClass: 'successSnack',
            });
          }
      }),
      catchError((error) => {
        if (request.method == 'POST' || request.method == 'PUT') {
          this.snackBar.open('Error while saving.', 'close', {
            duration: 2000,
            panelClass: 'errorSnack',
          });
          return throwError(error);
        }
        else if (request.method == 'GET') {
          this.snackBar.open('Error while fetching results.', 'close', {
            duration: 2000,
            panelClass: 'errorSnack',
          });
          return throwError(error);
        }
        else if (request.method == 'DELETE') {
          this.snackBar.open('Error while deleting.', 'close', {
            duration: 2000,
            panelClass: 'errorSnack',
          });
          return throwError(error);
        }
      })
    );
  }
}
