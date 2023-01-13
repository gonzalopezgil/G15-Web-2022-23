import { Company } from './../interfaces/company';
import { AuthService } from 'src/app/services/auth.service';
import { FormGroup } from '@angular/forms';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tutor } from '../interfaces/tutor';
import { Observable } from 'rxjs';
import { Report } from '../interfaces/report';
import { Practice } from '../interfaces/practice';
import { Offer } from '../interfaces/offer';
import { PracticesService } from './practices.service';
import { EnvService } from './env.service';

@Injectable({
  providedIn: 'root'
})
export class TutorsService {

  constructor(private http: HttpClient, private authService: AuthService, private practiceService: PracticesService, private envService: EnvService) { }


  getTutor(): Observable<any> {
    let id = this.authService.getId();
    let token = sessionStorage.getItem('token');
    let httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      }
    };

    return this.http.get<any>(this.envService.getApiUrl()+'/api/users/tutors/'+id, httpOptions);
  }

  getStubbyTutor(): Tutor {
     return {
      name: 'Juan',
      lastname: 'Pérez',
      username: 'juanperez',
      nif: '12345678A',
      email: 'xd@gmail.com',
      admission_date: new Date(),
      active: true
    };
  }

  registerCompany(form: FormGroup) {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.post(this.envService.getApiUrl()+'/api/company', {
      address: form.value.address,
      city: form.value.city,
      description: form.value.description,
      mail_suffix: form.value.mail_suffix,
      name: form.value.name,
      phone: form.value.phone,
      postal_code: form.value.postal_code,
    }, httpOptions);
  }

  getCompanybyName(name:String): Observable<Company> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.get<Company>(this.envService.getApiUrl()+'/api/company/'+name, httpOptions);
  }

  getCompany(id_company: any): Observable<Company> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    return this.http.get<Company>(this.envService.getApiUrl()+'/api/company/'+id_company, httpOptions);
  }

  registerOffer(form: FormGroup) {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken(),
      }
    };
    let comp:Company;
    this.getCompanybyName(form.value.empresa).subscribe(data => {
      comp=data;
      return this.http.post(this.envService.getApiUrl()+'/api/practices/offers', {


    });
  });


  }

  deletePractice(form: FormGroup) {
    /**return this.http.delete('http://localhost:3000/api/practices', {
      empresa: form.value.empresa
    });**/
    console.log(form.value);
  }

  changeTutor(form: FormGroup) {
    let company: Company;
    this.getCompanybyName(form.value.company).subscribe(data => {
      company = data;
    return this.http.put(this.envService.getApiUrl()+'/api/tutors', {
      company: form.value.company,
      newtutor: form.value.newtutor
    });
  });
}

  createTutor(form: FormGroup): boolean {
    /**return this.http.post('http://localhost:3000/api/tutors', {
      company: form.value.company,
      newtutor: form.value.newtutor
    });**/
    console.log(form.value);
    return true;
  }

  changePassword(password: string, oldpassword: string, confirmPassword: string) {
    console.log("Cambio password de tutor");
    console.log('oldpassword: ' + oldpassword);
    console.log('Password changed to: ' + password);
    console.log('Confirm password: ' + confirmPassword);
  }

  getPracticesByTutor(): Observable<any> {
    let id = this.authService.getId();
    let token = sessionStorage.getItem('token');
    let httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      }
    };
    return this.http.get<Practice[]>(this.envService.getApiUrl()+'/api/users/tutors/'+id+'/practices', httpOptions);
  }

  getOffersByTutor(): Observable<Offer[]> {
    let id = this.authService.getId();
    let token = sessionStorage.getItem('token');
    let httpOptions = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      }
    };
    return this.http.get<Offer[]>(this.envService.getApiUrl()+'/api/users/tutors/'+id+'/offers', httpOptions);
  }


  registerTutor(tutor: Tutor): Observable<any> {
    return this.http.post(this.envService.getApiUrl()+'/api/users/tutors', tutor);
  }
}

