import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpPracticesComponent } from './pop-up-practices.component';

describe('PopUpPracticesComponent', () => {
  let component: PopUpPracticesComponent;
  let fixture: ComponentFixture<PopUpPracticesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpPracticesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpPracticesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
