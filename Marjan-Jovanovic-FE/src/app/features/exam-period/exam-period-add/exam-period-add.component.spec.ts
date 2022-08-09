import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPeriodAddComponent } from './exam-period-add.component';

describe('ExamPeriodAddComponent', () => {
  let component: ExamPeriodAddComponent;
  let fixture: ComponentFixture<ExamPeriodAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPeriodAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPeriodAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
