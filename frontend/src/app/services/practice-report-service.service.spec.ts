import { TestBed } from '@angular/core/testing';

import { PracticeReportServiceService } from './practice-report-service.service';

describe('PracticeReportServiceService', () => {
  let service: PracticeReportServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PracticeReportServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
