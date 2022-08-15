import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPeriodDetailsComponent } from './exam-period-details.component';

describe('ExamPeriodDetailsComponent', () => {
  let component: ExamPeriodDetailsComponent;
  let fixture: ComponentFixture<ExamPeriodDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPeriodDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPeriodDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
