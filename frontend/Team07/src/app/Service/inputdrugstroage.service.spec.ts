import { TestBed } from '@angular/core/testing';
import { InputdrugstroageService } from './inputdrugstroage.service';
describe('InputdrugstroageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InputdrugstroageService = TestBed.get(InputdrugstroageService);
    expect(service).toBeTruthy();
  });
});
