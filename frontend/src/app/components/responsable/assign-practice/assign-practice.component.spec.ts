import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignPracticeComponent } from './assign-practice.component';

describe('AssignPracticeComponent', () => {
  let component: AssignPracticeComponent;
  let fixture: ComponentFixture<AssignPracticeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignPracticeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
