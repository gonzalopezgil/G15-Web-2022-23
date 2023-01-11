import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpTutorregisterComponent } from './pop-up-tutorregister.component';

describe('PopUpTutorregisterComponent', () => {
  let component: PopUpTutorregisterComponent;
  let fixture: ComponentFixture<PopUpTutorregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpTutorregisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpTutorregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
