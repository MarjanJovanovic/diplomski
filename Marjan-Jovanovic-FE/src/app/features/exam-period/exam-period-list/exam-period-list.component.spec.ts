import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPeriodListComponent } from './exam-period-list.component';

describe('ExamPeriodListComponent', () => {
  let component: ExamPeriodListComponent;
  let fixture: ComponentFixture<ExamPeriodListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPeriodListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPeriodListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
