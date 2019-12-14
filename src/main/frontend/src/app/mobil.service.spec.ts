import { TestBed } from '@angular/core/testing';

import { MobilService } from './mobil.service';

describe('MobilService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MobilService = TestBed.get(MobilService);
    expect(service).toBeTruthy();
  });
});
