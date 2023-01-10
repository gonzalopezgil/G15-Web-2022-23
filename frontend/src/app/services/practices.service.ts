import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Offer } from '../interfaces/offer';
import { ELEMENT_DATA } from '../mocks/practicas.mock';

@Injectable({
  providedIn: 'root'
})
export class PracticesService {
  constructor(private http: HttpClient) { }
  
    getPractices(): Offer[] {
      let data= ELEMENT_DATA;
      return data;
    }

    getPractice(id: number): Offer {
      let data= ELEMENT_DATA;
      return data[id];
    }
}
