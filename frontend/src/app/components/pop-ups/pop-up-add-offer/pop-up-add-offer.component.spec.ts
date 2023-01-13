import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpAddOfferComponent } from './pop-up-add-offer.component';

describe('PopUpAddOfferComponent', () => {
  let component: PopUpAddOfferComponent;
  let fixture: ComponentFixture<PopUpAddOfferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpAddOfferComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpAddOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
