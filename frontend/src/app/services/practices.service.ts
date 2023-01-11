import { AuthService } from 'src/app/services/auth.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Offer } from '../interfaces/offer';
import { Observable } from 'rxjs';
import { Company } from '../interfaces/company';

@Injectable({
  providedIn: 'root'
})
export class PracticesService {
  constructor(private http: HttpClient,private authService: AuthService) { }
  
    
    getOffers(): Observable<Offer[]>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<Offer[]>("http://localhost:8080/api/practices/offers", httpOptions);
    }

    getCompanyName(id: number): Observable<Company>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<Company>("http://localhost:8080/api/company/"+id, httpOptions);
    }
}
