import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorregisterPagesComponent } from './tutorregister-pages.component';

describe('TutorregisterPagesComponent', () => {
  let component: TutorregisterPagesComponent;
  let fixture: ComponentFixture<TutorregisterPagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorregisterPagesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TutorregisterPagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
