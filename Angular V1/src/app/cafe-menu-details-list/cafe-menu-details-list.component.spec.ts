import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CafeMenuDetailsListComponent } from './cafe-menu-details-list.component';

describe('CafeMenuDetailsListComponent', () => {
  let component: CafeMenuDetailsListComponent;
  let fixture: ComponentFixture<CafeMenuDetailsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CafeMenuDetailsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CafeMenuDetailsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
