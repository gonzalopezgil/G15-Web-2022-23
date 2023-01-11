import { Injectable } from '@angular/core';
import { Solicitud } from '../interfaces/solicitud';
import { ELEMENT_DATA } from '../mocks/solicitudes.mock';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SolicitudService {

  constructor(private http: HttpClient) { }
  getSolicitudes (): Solicitud[] {
    let data= ELEMENT_DATA;
    return data;
  }
}
