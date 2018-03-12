import { TestBed, inject } from '@angular/core/testing';

import { TecnicService } from './tecnic.service';

describe('TecnicService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TecnicService]
    });
  });

  it('should be created', inject([TecnicService], (service: TecnicService) => {
    expect(service).toBeTruthy();
  }));
});
