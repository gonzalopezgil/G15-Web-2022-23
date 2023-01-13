import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangetutorcompanyComponent } from './changetutorcompany.component';

describe('ChangetutorcompanyComponent', () => {
  let component: ChangetutorcompanyComponent;
  let fixture: ComponentFixture<ChangetutorcompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangetutorcompanyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangetutorcompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
