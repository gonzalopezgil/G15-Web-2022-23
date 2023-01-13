import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Practica } from '../interfaces/practica';
import { ELEMENT_DATA } from '../mocks/practicas.mock';
import { Observable } from 'rxjs';
import { PracticaUser } from '../interfaces/practica-user';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class PracticesService {
  constructor(private http: HttpClient, private authService:AuthService) { }

    getPractices(): Practica[] {
      let data= ELEMENT_DATA;
      return data;
    }
    getPracticesResponsable(): Observable<PracticaUser[]>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<PracticaUser[]>('http://localhost:8080/api/practices/', httpOptions);
    }
    confirmAssignation(): Observable<any>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.post('http://localhost:8080/api/practices/assign-practices',httpOptions)
    }

    getPractice(id: number): Practica {
      let data= ELEMENT_DATA;
      return data[id];
    }
    getReport(): Observable<any>{
      const options = {
        headers: {
          'Content-Type': 'application/pdf',
          'Authorization': 'Bearer ' + this.authService.getToken(),
          'Content-disposition': 'attachment;filename="filename.pdf"',
          'Content-Description' :' File Transfer',
          'Pragma': 'public',
        },
        responseType: 'blob' as 'json'
      };
      return this.http.get('http://localhost:8080/api/practices/report',options)
    }
}
