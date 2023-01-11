import { FormGroup } from '@angular/forms';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tutor } from '../interfaces/tutor';
import { Observable } from 'rxjs';
import { Report } from '../interfaces/report';
import { reports } from '../mocks/reports.mock';

@Injectable({
  providedIn: 'root'
})
export class TutorsService {

  constructor(private http: HttpClient) { }

  getTutor(): Tutor {
    return {
      name: 'Juan',
      lastname: 'Pérez',
      username: 'juanperez',
      nif: '12345678A',
      email: 'xd@gmail.com',
      admissionDate: new Date(),
    };

  }

  registerPractice(form: FormGroup) {
    /**return this.http.post('http://localhost:3000/api/practices', {
      titulo: form.value.titulo,
      empresa: form.value.empresa,
      plazas: form.value.plazas,
      horario: form.value.horario,
      dias: form.value.dias,
      semanas: form.value.semanas
    });**/
    console.log(form.value);
  }

  deletePractice(form: FormGroup) {
    /**return this.http.delete('http://localhost:3000/api/practices', {
      empresa: form.value.empresa
    });**/
    console.log(form.value);
  }

  changeTutor(form: FormGroup) {
    /**return this.http.put('http://localhost:3000/api/tutors', {
      company: form.value.company,
      newtutor: form.value.newtutor
    });**/
    console.log(form.value);
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

  getReports(): Report[] {
    return reports;
  }

  saveReports(reports: Report[]) {
    console.log(reports);
  }

  registerTutor(tutor: Tutor): Observable<any> {
    return this.http.post('http://localhost:3000/api/tutors', tutor);
  }

}

