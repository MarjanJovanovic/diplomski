import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamAddComponent } from './exam-add.component';

describe('ExamAddComponent', () => {
  let component: ExamAddComponent;
  let fixture: ComponentFixture<ExamAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
