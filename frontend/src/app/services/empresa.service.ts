import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from '../interfaces/company';
import { AuthService } from './auth.service';
import { EnvService } from './env.service';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor(private http:HttpClient, private authService:AuthService, private envService:EnvService) { }
  getCompanyById(idEmpresa:number): Observable<Company>{
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.get<Company>(this.envService.getApiUrl()+'/api/company/'+idEmpresa, httpOptions)
  }
}
