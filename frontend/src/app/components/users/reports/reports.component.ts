import { Component ,OnInit} from '@angular/core';
import { Practica } from 'src/app/interfaces/practica';
import { User } from 'src/app/interfaces/user';
import { Tutor } from 'src/app/interfaces/tutor';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent {
  practice: Practica | undefined;
  user: User | undefined;
  tutor: Tutor | undefined;
  constructor() { }

  ngOnInit(): void {
    this.user = {name: 'John'};
    this.tutor = {name: 'Carlos'};
    this.practice = {id:1,posicion: 1,titulo: 'Practica 1', empresa: 'Empresa 1', plazas: 3, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4};
  }

}
