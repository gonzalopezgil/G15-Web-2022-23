import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

    login(username: string, password: string): Observable<any> {
      let body = {
        username: username,
        password: password
      }

      return this.http.post("http://localhost:8080/api/users/login", body);
    }
    logout(): void {
      sessionStorage.removeItem('token');
    }

    getToken(): String {
      return sessionStorage.getItem('token') || '';
    }


    getId(): number {
      const helper = new JwtHelperService();
      let token = sessionStorage.getItem('token');
      let id = -1;
      if (token){
        let decodedToken = helper.decodeToken(token);
        id = decodedToken["id"];
      }
      return id;
    }

    getRole(): String {
      const helper = new JwtHelperService();
      let token = sessionStorage.getItem('token');
      let role = "";
      if (token){
        let decodedToken = helper.decodeToken(token);
        role = decodedToken["CLAIM_TOKEN"][0].authority;
      }
      return role;
    }

    getSubject() {
      const helper = new JwtHelperService();
      let token = sessionStorage.getItem('token');
      let subject = "";
      if (token){
        let decodedToken = helper.decodeToken(token);
        subject = decodedToken.sub;
      }
      return subject;
    }
}
