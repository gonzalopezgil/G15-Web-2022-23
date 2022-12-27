import {SelectionModel} from '@angular/cdk/collections';
import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';

export interface Practica {
  id: number;
  posicion: number;
  titulo: string;
  empresa: string;
  plazas: number;
  horario: string;
  dias: string;
  semanas: number;
}

const ELEMENT_DATA: Practica[] = [
  {id:1,posicion: 1,titulo: 'Practica 1', empresa: 'Empresa 1', plazas: 3, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:2,posicion: 2,titulo: 'Practica 2', empresa: 'Empresa 2', plazas: 2, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:3,posicion: 3,titulo: 'Practica 3', empresa: 'Empresa 3', plazas: 1, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:4,posicion: 4,titulo: 'Practica 4', empresa: 'Empresa 4', plazas: 4, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:5,posicion: 5,titulo: 'Practica 5', empresa: 'Empresa 5', plazas: 5, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:6,posicion: 6,titulo: 'Practica 6', empresa: 'Empresa 6', plazas: 6, horario: '8:00-14:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:7,posicion: 7,titulo: 'Practica 7', empresa: 'Empresa 7', plazas: 7, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:8,posicion: 8,titulo: 'Practica 8', empresa: 'Empresa 8', plazas: 8, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:9,posicion: 9,titulo: 'Practica 9', empresa: 'Empresa 9', plazas: 9, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:10,posicion: 10,titulo: 'Practica 10', empresa: 'Empresa 10', plazas: 10, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:11,posicion: 11,titulo: 'Practica 11', empresa: 'Empresa 11', plazas: 11, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:12,posicion: 12,titulo: 'Practica 12', empresa: 'Empresa 12', plazas: 12, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:13,posicion: 13,titulo: 'Practica 13', empresa: 'Empresa 13', plazas: 13, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:14,posicion: 14,titulo: 'Practica 14', empresa: 'Empresa 14', plazas: 14, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
  {id:15,posicion: 15,titulo: 'Practica 15', empresa: 'Empresa 15', plazas: 15, horario: '10:00-16:00', dias: 'Lunes a Viernes', semanas: 4},
];

/**
 * @title Table with selection
 */
/**
 * @title Table with sorting
 */
@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesComponent {
  displayedColumns: string[] = [ 'Posicion','Titulo', 'Empresa', 'Plazas', 'Horario','Dias de la semana','Semanas','select'];
  dataSource = new MatTableDataSource<Practica>(ELEMENT_DATA);
  selection = new SelectionModel<Practica>(true, []);

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Practica): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.posicion + 1}`;
  }

  guardar(): void {
    let practicasSeleccionadas: Practica[] = [];
       for (let item of this.selection.selected) {
         console.log(item.id);
         practicasSeleccionadas.push(item);
       }
       if (practicasSeleccionadas.length > 10) {
         alert("No se pueden seleccionar mas de 10 practicas");
         this.selection.clear();
       }
  }
}