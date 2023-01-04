import { FormGroup } from '@angular/forms';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tutor } from '../interfaces/tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorsService {

  constructor(private http: HttpClient) { }

  getTutor(): Tutor {
    return {name: 'Juan'};
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
}

