import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterofferComponent } from './registeroffer.component';

describe('RegistercompanyComponent', () => {
  let component: RegisterofferComponent;
  let fixture: ComponentFixture<RegisterofferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterofferComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterofferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
