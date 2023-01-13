import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsabledataComponent } from './responsabledata.component';

describe('ResponsabledataComponent', () => {
  let component: ResponsabledataComponent;
  let fixture: ComponentFixture<ResponsabledataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsabledataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResponsabledataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
