import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpAssignPracticesComponent } from './pop-up-assign-practices.component';

describe('PopUpAssignPracticesComponent', () => {
  let component: PopUpAssignPracticesComponent;
  let fixture: ComponentFixture<PopUpAssignPracticesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpAssignPracticesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpAssignPracticesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
