import { TestBed } from '@angular/core/testing';

import { DrugService } from './drug.service';

describe('DrugService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DrugService = TestBed.get(DrugService);
    expect(service).toBeTruthy();
  });
});
