import { TestBed } from '@angular/core/testing';

import { ResistanceService } from './resistance.service';

describe('ResistanceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ResistanceService = TestBed.get(ResistanceService);
    expect(service).toBeTruthy();
  });
});
