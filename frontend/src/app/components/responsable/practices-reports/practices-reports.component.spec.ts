import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticesReportsComponent } from './practices-reports.component';

describe('PracticesReportsComponent', () => {
  let component: PracticesReportsComponent;
  let fixture: ComponentFixture<PracticesReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticesReportsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PracticesReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
