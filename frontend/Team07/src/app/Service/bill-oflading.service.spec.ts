import { TestBed, inject } from '@angular/core/testing';

import { BillOfladingService } from './bill-oflading.service';

describe('BillOfladingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BillOfladingService]
    });
  });

  it('should be created', inject([BillOfladingService], (service: BillOfladingService) => {
    expect(service).toBeTruthy();
  }));
});
