import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationTutorsComponent } from './navigation-tutors.component';

describe('NavigationTutorsComponent', () => {
  let component: NavigationTutorsComponent;
  let fixture: ComponentFixture<NavigationTutorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigationTutorsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavigationTutorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
