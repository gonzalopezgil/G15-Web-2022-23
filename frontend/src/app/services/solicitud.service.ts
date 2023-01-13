import { Injectable } from '@angular/core';
import { Solicitud } from '../interfaces/solicitud';
import { ELEMENT_DATA } from '../mocks/solicitudes.mock';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SolicitudService {

  constructor(private http: HttpClient, private authService: AuthService) { }
  getSolicitudes (): Observable<Solicitud[]> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.post<Solicitud[]>('http://localhost:8080/api/practices/assign-practices',httpOptions)
  }
}
