import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticesOngoingComponent } from './practices-ongoing.component';

describe('PracticesOngoingComponent', () => {
  let component: PracticesOngoingComponent;
  let fixture: ComponentFixture<PracticesOngoingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticesOngoingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PracticesOngoingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
