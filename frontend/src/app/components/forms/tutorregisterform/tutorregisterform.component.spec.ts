import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorregisterformComponent } from './tutorregisterform.component';

describe('TutorregisterformComponent', () => {
  let component: TutorregisterformComponent;
  let fixture: ComponentFixture<TutorregisterformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorregisterformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TutorregisterformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
