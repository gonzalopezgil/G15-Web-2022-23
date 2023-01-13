import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutordataComponent } from './tutordata.component';

describe('TutordataComponent', () => {
  let component: TutordataComponent;
  let fixture: ComponentFixture<TutordataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutordataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TutordataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
