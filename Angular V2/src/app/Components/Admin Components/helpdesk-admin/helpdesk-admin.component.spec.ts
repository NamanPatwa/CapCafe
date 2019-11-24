import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelpdeskAdminComponent } from './helpdesk-admin.component';

describe('HelpdeskAdminComponent', () => {
  let component: HelpdeskAdminComponent;
  let fixture: ComponentFixture<HelpdeskAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelpdeskAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelpdeskAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
