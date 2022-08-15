import { TestBed } from '@angular/core/testing';

import { HttpErrorInterceptorInterceptor } from './http-error-interceptor.interceptor';

describe('HttpErrorInterceptorInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HttpErrorInterceptorInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: HttpErrorInterceptorInterceptor = TestBed.inject(HttpErrorInterceptorInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
