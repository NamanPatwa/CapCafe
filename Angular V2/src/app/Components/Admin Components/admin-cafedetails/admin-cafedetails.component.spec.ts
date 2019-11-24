import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCafedetailsComponent } from './admin-cafedetails.component';

describe('AdminCafedetailsComponent', () => {
  let component: AdminCafedetailsComponent;
  let fixture: ComponentFixture<AdminCafedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCafedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCafedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
