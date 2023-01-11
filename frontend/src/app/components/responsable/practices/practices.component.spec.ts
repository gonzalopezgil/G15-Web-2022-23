import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticesReportComponent } from './practices.component';

describe('PracticesComponent', () => {
  let component: PracticesReportComponent;
  let fixture: ComponentFixture<PracticesReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticesReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PracticesReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
