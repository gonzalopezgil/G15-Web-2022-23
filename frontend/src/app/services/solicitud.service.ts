import { Injectable } from '@angular/core';
import { Solicitud } from '../interfaces/solicitud';
import { ELEMENT_DATA } from '../mocks/solicitudes.mock';

@Injectable({
  providedIn: 'root'
})
export class SolicitudService {

  constructor() { }
  getSolicitudes (): Solicitud[] {
    let data= ELEMENT_DATA;
    return data;
  }
}
