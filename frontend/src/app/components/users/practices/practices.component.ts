import {SelectionModel} from '@angular/cdk/collections';
import {Component, EventEmitter, Output,OnInit, AfterViewInit, ViewChild, ChangeDetectorRef} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Company } from 'src/app/interfaces/company';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';
import { PopUpPracticesComponent } from '../../pop-ups/pop-up-practices/pop-up-practices.component';

@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesComponent implements AfterViewInit{
  displayedColumns: string[] = [ 'Posicion','Titulo', 'Empresa', 'Plazas', 'Horario','Semanas','select'];
  dataSource = new MatTableDataSource<Offer>();
  selection = new SelectionModel<Offer>(true, []);
  @Output() messageEvent = new EventEmitter<Offer[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private dialog: MatDialog,private PracticesService: PracticesService,private practiceService: PracticesService){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  ngOnInit(): void{
    this.PracticesService.getOffers().subscribe((data: Offer[]) => {
      for (let i = 0; i < data.length; i++) {
        data[i].pos = data[i].id;
        this.PracticesService.getCompanyName(data[i].company_id).subscribe((company:Company) => {
          data[i].company_name = company.name;
        });
      }
      this.dataSource.data = data;
    });
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
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.pos + 1}`;
  }

  guardar(): void {
    let practicasSeleccionadas: Offer[] = [];
       for (let item of this.selection.selected) {
         practicasSeleccionadas.push(item);
       }
       this.dialog.open(PopUpPracticesComponent, {
         data: practicasSeleccionadas});
  }
}
