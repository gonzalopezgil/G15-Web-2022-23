import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();

  constructor(private http: HttpClient) {
    const token = sessionStorage.getItem('token');
    this._isLoggedIn$.next(!!token);
   }
  
    login(username: string, password: string): Observable<any> {
      let body = {
        password: password,
        username: username,
      }
      
      return this.http.post('http://localhost:8080/api/users/login', body).pipe(
        tap((res: any) => {
          this._isLoggedIn$.next(true);
          sessionStorage.setItem('token', res.token);
        }));
    }
    
    logout(): void {
      sessionStorage.removeItem('token');
    }
}
