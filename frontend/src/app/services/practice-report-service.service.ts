import { Injectable } from '@angular/core';
import { practiceReport } from '../interfaces/practiceReport';
import { ELEMENT_DATA } from '../mocks/informes.mock';

@Injectable({
  providedIn: 'root'
})
export class PracticeReportServiceService {

  constructor() { }
  getPracticesReport():practiceReport[]{
    let data= ELEMENT_DATA;
    return data;
  }
}
