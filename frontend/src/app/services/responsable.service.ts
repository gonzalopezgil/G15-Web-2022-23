import { Injectable } from '@angular/core';
import { responsable } from '../interfaces/responsable';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ResponsableService {

  constructor() { }
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

    return responsable;
  }
  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }
}
