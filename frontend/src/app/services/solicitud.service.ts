import { Injectable } from '@angular/core';
import { Solicitud } from '../interfaces/solicitud';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { EnvService } from './env.service';

@Injectable({
  providedIn: 'root'
})
export class SolicitudService {

  constructor(private http: HttpClient, private authService: AuthService, private envService:EnvService) { }
  getSolicitudes (): Observable<Solicitud[]> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.post<Solicitud[]>(this.envService.getApiUrl()+'/api/practices/assign-practices',httpOptions)
  }
}
