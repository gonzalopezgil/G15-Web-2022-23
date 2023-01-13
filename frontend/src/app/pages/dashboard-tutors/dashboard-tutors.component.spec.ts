import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardTutorsComponent } from './dashboard-tutors.component';

describe('DashboardTutorsComponent', () => {
  let component: DashboardTutorsComponent;
  let fixture: ComponentFixture<DashboardTutorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardTutorsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardTutorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
