import {SelectionModel} from '@angular/cdk/collections';
import {Component, EventEmitter, Output,OnInit} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Practica } from 'src/app/interfaces/practica';
import { PracticesService } from 'src/app/services/practices.service';
import { PopUpPracticesComponent } from '../../pop-ups/pop-up-practices/pop-up-practices.component';

@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesComponent {
  displayedColumns: string[] = [ 'Posicion','Titulo', 'Empresa', 'Plazas', 'Horario','Dias de la semana','Semanas','select'];
  dataSource = new MatTableDataSource<Practica>();
  selection = new SelectionModel<Practica>(true, []);
  @Output() messageEvent = new EventEmitter<Practica[]>();

  constructor(private dialog: MatDialog,private PracticesService: PracticesService){}

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  ngOnInit(): void{
    this.dataSource.data = this.PracticesService.getPractices();
  }

  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  
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
       this.dialog.open(PopUpPracticesComponent, {
         data: practicasSeleccionadas});       
  }
}