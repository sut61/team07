import { TestBed } from '@angular/core/testing';

import { RedcorduseService } from './redcorduse.service';

describe('RedcorduseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RedcorduseService = TestBed.get(RedcorduseService);
    expect(service).toBeTruthy();
  });
});
