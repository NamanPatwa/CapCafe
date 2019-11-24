import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOrderInfoComponent } from './user-order-info.component';

describe('UserOrderInfoComponent', () => {
  let component: UserOrderInfoComponent;
  let fixture: ComponentFixture<UserOrderInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserOrderInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserOrderInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
