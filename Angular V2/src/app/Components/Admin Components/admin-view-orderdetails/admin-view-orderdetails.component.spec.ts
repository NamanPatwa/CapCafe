import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewOrderdetailsComponent } from './admin-view-orderdetails.component';

describe('AdminViewOrderdetailsComponent', () => {
  let component: AdminViewOrderdetailsComponent;
  let fixture: ComponentFixture<AdminViewOrderdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewOrderdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewOrderdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
