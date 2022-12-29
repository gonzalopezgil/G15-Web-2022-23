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
}

