import { TestBed } from '@angular/core/testing';

import { RentACarServiceServiceService } from './rent-a-car-service-service.service';

describe('RentACarServiceServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RentACarServiceServiceService = TestBed.get(RentACarServiceServiceService);
    expect(service).toBeTruthy();
  });
});
