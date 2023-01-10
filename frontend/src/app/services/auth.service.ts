import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  
    login(username: string, password: string): Observable<any>{
      let body = {
        password: password,
        username: username,
        
      }
      
      return this.http.post('http://localhost:8080/api/users/login', body);
    }
    logout(): void {
      sessionStorage.removeItem('token');
    }
}
