import { TestBed } from '@angular/core/testing';

import { HelpdeskUserService } from './helpdesk-user.service';

describe('HelpdeskUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HelpdeskUserService = TestBed.get(HelpdeskUserService);
    expect(service).toBeTruthy();
  });
});
