import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Offers } from '../interfaces/offers'
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { EnvService } from './env.service';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http:HttpClient, private authService:AuthService, private envService:EnvService) { }
  getOfferById(idOferta:number): Observable<Offers>{
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.get<Offers>(this.envService.getApiUrl()+'/api/practices/offers/'+idOferta, httpOptions);
  }
}
