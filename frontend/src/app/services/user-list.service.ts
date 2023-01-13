import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ELEMENT_DATA } from '../mocks/usuarios.mock';
@Injectable({
  providedIn: 'root'
})
export class UserListService {

  constructor(private http: HttpClient) {  }
  getUsersList(){
    let data = ELEMENT_DATA;
    return data;
  }
}
