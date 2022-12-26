import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageUsersComponent } from './home-page-users.component';

describe('HomePageComponent', () => {
  let component: HomePageUsersComponent;
  let fixture: ComponentFixture<HomePageUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomePageUsersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomePageUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
