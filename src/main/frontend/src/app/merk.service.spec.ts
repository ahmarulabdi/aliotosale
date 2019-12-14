import { TestBed } from '@angular/core/testing';

import { MerkService } from './merk.service';

describe('MerkService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MerkService = TestBed.get(MerkService);
    expect(service).toBeTruthy();
  });
});
