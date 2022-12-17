import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FaqHelpComponent } from './faq-help.component';

describe('FaqHelpComponent', () => {
  let component: FaqHelpComponent;
  let fixture: ComponentFixture<FaqHelpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FaqHelpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FaqHelpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
