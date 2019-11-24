import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCafeFeedbackComponent } from './view-cafe-feedback.component';

describe('ViewCafeFeedbackComponent', () => {
  let component: ViewCafeFeedbackComponent;
  let fixture: ComponentFixture<ViewCafeFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCafeFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCafeFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
