import { TestBed } from '@angular/core/testing';

import { HelpdeskAdminService } from './helpdesk-admin.service';

describe('HelpdeskAdminService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HelpdeskAdminService = TestBed.get(HelpdeskAdminService);
    expect(service).toBeTruthy();
  });
});
