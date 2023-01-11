import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tutor } from '../interfaces/tutor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TutorsService {

  constructor(private http: HttpClient) { }

  getTutor(): Tutor {
    return {name: 'Juan', surname: 'Pérez', email: 'w@g', nif: '123', password:'123', username:'123'};
  }

  registerTutor(tutor: Tutor): Observable<any> {
    return this.http.post('http://localhost:8080/api/tutors', tutor);
  }
}

