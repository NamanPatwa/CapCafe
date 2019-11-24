import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelpdeskUserComponent } from './helpdesk-user.component';

describe('HelpdeskUserComponent', () => {
  let component: HelpdeskUserComponent;
  let fixture: ComponentFixture<HelpdeskUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelpdeskUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelpdeskUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
