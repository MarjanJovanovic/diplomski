import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorAddComponent } from './professor-add.component';

describe('ProfessorAddComponent', () => {
  let component: ProfessorAddComponent;
  let fixture: ComponentFixture<ProfessorAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
