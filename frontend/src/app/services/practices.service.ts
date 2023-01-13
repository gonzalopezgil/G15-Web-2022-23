import { Practica } from './../interfaces/practica';
import { AuthService } from 'src/app/services/auth.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PracticaUser } from '../interfaces/practica-user';
import { Offer } from '../interfaces/offer';
import { Company } from '../interfaces/company';
import { Practice } from '../interfaces/practice';
import { SimpleOffer } from '../interfaces/simple_offer';

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

    getOffer(id: any): Observable<Offer>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<Offer>("http://localhost:8080/api/practices/offers/"+id, httpOptions);
    }

    updateOffer(offer: Offer){
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.put("http://localhost:8080/api/practices/offers/"+offer.id, offer, httpOptions);
    }


    saveOffer(offer: SimpleOffer){
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.post("http://localhost:8080/api/practices/offers/", offer, httpOptions);
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
    getPracticesResponsable(): Observable<PracticaUser[]>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.get<PracticaUser[]>('http://localhost:8080/api/practices/', httpOptions);
    }
    confirmAssignation(): Observable<any>{
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.post('http://localhost:8080/api/practices/assign-practices',httpOptions)
    }

    savePractice(practice: Practice){
      const httpOptions = {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + this.authService.getToken(),
        }
      };
      return this.http.post("http://localhost:8080/api/practices/", practice, httpOptions);
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
    getReport(): Observable<any>{
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
      return this.http.get('http://localhost:8080/api/practices/report',options)
    }
}
