import { TestBed } from '@angular/core/testing';
import { DrugdataService } from './drugdata.service';
describe('DrugdataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DrugdataService = TestBed.get(DrugdataService);
    expect(service).toBeTruthy();
  });
});
