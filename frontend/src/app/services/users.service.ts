import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  getUser(): User {
    let user:User = {
      name: 'Carlos',
      username: 'carlos',
      lastname: 'Fernandez',
      dni:  '12345678',
      mail: 'carlos@gmail.com',
      grade: '1',
      dob: '01/01/2000',
      phone: '123456789',
      hours: 0
    }

    return user;
  }

  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }

  user_type(){
    let user_type = 1;
    return user_type;
  }
}
