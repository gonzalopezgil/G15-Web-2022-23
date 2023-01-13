import { Injectable } from '@angular/core';
import { responsable } from '../interfaces/responsable';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { EnvService } from './env.service';
@Injectable({
  providedIn: 'root'
})
export class ResponsableService {

  constructor(private authService: AuthService, private http:HttpClient, private envService: EnvService) { }
  getResponsable(): Observable<responsable> {
    let token = this.authService.getToken();
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token,
      }
    };
    let idResponsable = this.authService.getId();
    return this.http.get<responsable>(this.envService.getApiUrl()+'/api/users/supervisors/'+idResponsable, httpOptions);
  }
  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }
}
