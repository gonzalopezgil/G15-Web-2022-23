import { Practica } from './../interfaces/practica';
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
    getPractices(): Observable<Practica[]>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<Practica[]>("http://localhost:8080/api/practices", httpOptions);
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
    selectPractices(practices: Offer[]){
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      let id = -1;
      id = this.authService.getId();
      let array = [];
      for (let i = 0; i < practices.length; i++) {
        array.push({"offerId" : practices[i].id ,
                    "preference" : i+1});
      }
      console.log(JSON.parse(JSON.stringify(array)));
      return this.http.post("http://localhost:8080/api/users/students/2/selection", practices, httpOptions);
    }
}
