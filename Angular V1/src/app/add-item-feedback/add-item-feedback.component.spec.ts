import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddItemFeedbackComponent } from './add-item-feedback.component';

describe('AddItemFeedbackComponent', () => {
  let component: AddItemFeedbackComponent;
  let fixture: ComponentFixture<AddItemFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddItemFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddItemFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
