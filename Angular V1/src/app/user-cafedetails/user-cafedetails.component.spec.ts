import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCafedetailsComponent } from './user-cafedetails.component';

describe('UserCafedetailsComponent', () => {
  let component: UserCafedetailsComponent;
  let fixture: ComponentFixture<UserCafedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCafedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCafedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
