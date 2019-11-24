import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewItemFeedbackComponent } from './view-item-feedback.component';

describe('ViewItemFeedbackComponent', () => {
  let component: ViewItemFeedbackComponent;
  let fixture: ComponentFixture<ViewItemFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewItemFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewItemFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
