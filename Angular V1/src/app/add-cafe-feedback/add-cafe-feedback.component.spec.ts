import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCafeFeedbackComponent } from './add-cafe-feedback.component';

describe('AddCafeFeedbackComponent', () => {
  let component: AddCafeFeedbackComponent;
  let fixture: ComponentFixture<AddCafeFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCafeFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCafeFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
