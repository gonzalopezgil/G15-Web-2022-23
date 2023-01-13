import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../interfaces/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient,private authService: AuthService) { }

  

  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log("Cambio password de user");
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }

  getStudent(): Observable<Student>{
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
      let id = this.authService.getId();
      return this.http.get<Student>("http://localhost:8080/api/users/students/"+id, httpOptions);

  }

  getPDF(): Observable<any>{
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
    let id = this.authService.getId();
    return this.http.get<any>("http://localhost:8080/api/users/students/"+ id + "/report",options);
  }

}
