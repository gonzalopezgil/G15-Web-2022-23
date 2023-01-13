import { throwDialogContentAlreadyAttachedError } from '@angular/cdk/dialog';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  getUser(): Observable<User> {
    let token = this.authService.getToken();
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token,
      }
    };
    let idResponsable = this.authService.getId();
    return this.http.get<User>('http://localhost:8080/api/users/'+idResponsable, httpOptions);
  }
  getUserById(idAlumno:number): Observable<User> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.get<User>('http://localhost:8080/api/users/students/'+idAlumno, httpOptions);
  }

  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log("Cambio password de user");
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }
}
