import { TestBed } from '@angular/core/testing';

import { ChartInService } from './chart-in.service';

describe('ChartInService', () => {
  let service: ChartInService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChartInService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
