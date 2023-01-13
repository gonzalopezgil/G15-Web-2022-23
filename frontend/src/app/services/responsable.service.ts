import { Injectable } from '@angular/core';
import { responsable } from '../interfaces/responsable';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { Token } from '@angular/compiler';
@Injectable({
  providedIn: 'root'
})
export class ResponsableService {

  constructor(private authService: AuthService, private http:HttpClient) { }
  getResponsable(): responsable {
    let responsable:responsable = {
      name: 'Pedro',
      username: 'pedro',
      lastname: 'Alvarez',
      dni:  '79959955',
      mail: 'pedro@gmail.com',
      f_alta: '02/05/2015',
      f_baja: '',
    }
    /*let token = this.authService.getToken();
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token,
      }
    };
    let token = sessionStorage.getItem('token').id;
    return this.http.get<responsable>('http://localhost:8080/api/offers/'+idOferta, httpOptions);*/
    return responsable;
  }
  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }
}
