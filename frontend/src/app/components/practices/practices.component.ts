import {SelectionModel} from '@angular/cdk/collections';
import {Component, EventEmitter, Output} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Practica } from 'src/app/interfaces/practica';
import { ELEMENT_DATA } from 'src/app/mocks/practicas.mock';
import { PopUpComponent } from '../pop-up/pop-up.component';

@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesComponent {
  displayedColumns: string[] = [ 'Posicion','Titulo', 'Empresa', 'Plazas', 'Horario','Dias de la semana','Semanas','select'];
  dataSource = new MatTableDataSource<Practica>(ELEMENT_DATA);
  selection = new SelectionModel<Practica>(true, []);
  @Output() messageEvent = new EventEmitter<Practica[]>();

  constructor(private dialog: MatDialog){}
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
       this.dialog.open(PopUpComponent, {
         data: practicasSeleccionadas});       
  }
}