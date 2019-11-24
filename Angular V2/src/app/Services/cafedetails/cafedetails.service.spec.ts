import { TestBed } from '@angular/core/testing';

import { CafedetailsService } from './cafedetails.service';

describe('CafedetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CafedetailsService = TestBed.get(CafedetailsService);
    expect(service).toBeTruthy();
  });
});
