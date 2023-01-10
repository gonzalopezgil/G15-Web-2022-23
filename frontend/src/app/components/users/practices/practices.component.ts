import {SelectionModel} from '@angular/cdk/collections';
import {Component, EventEmitter, Output,OnInit, AfterViewInit, ViewChild, ChangeDetectorRef} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';
import { PopUpPracticesComponent } from '../../pop-ups/pop-up-practices/pop-up-practices.component';

@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesComponent implements AfterViewInit{
  displayedColumns: string[] = [ 'Posicion','Titulo', 'Empresa', 'Plazas', 'Horario','Dias de la semana','Semanas','select'];
  dataSource = new MatTableDataSource<Offer>();
  selection = new SelectionModel<Offer>(true, []);
  @Output() messageEvent = new EventEmitter<Offer[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private dialog: MatDialog,private PracticesService: PracticesService){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
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

  
  checkboxLabel(row?: Offer): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.posicion + 1}`;
  }

  guardar(): void {
    let practicasSeleccionadas: Offer[] = [];
       for (let item of this.selection.selected) {
         console.log(item.id);
         practicasSeleccionadas.push(item);
       }
       this.dialog.open(PopUpPracticesComponent, {
         data: practicasSeleccionadas});       
  }
}