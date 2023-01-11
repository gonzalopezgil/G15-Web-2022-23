import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorreportsComponent } from './tutorreports.component';

describe('TutorreportsComponent', () => {
  let component: TutorreportsComponent;
  let fixture: ComponentFixture<TutorreportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorreportsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TutorreportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
