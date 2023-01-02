import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Practica } from '../interfaces/practica';
import { ELEMENT_DATA } from '../mocks/practicas.mock';

@Injectable({
  providedIn: 'root'
})
export class PracticesService {
  constructor(private http: HttpClient) { }
  
    getPractices(): Practica[] {
      let data= ELEMENT_DATA;
      return data;
    }

    getPractice(id: number): Practica {
      let data= ELEMENT_DATA;
      return data[id];
    }
}
