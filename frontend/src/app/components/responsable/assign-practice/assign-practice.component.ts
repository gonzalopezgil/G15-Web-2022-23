import {SelectionModel} from '@angular/cdk/collections';
import { Component, EventEmitter, Output, ViewChild, ChangeDetectorRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Solicitud } from 'src/app/interfaces/solicitud';
import { SolicitudService } from 'src/app/services/solicitud.service';
import { PopUpAssignPracticesComponent } from '../../pop-ups/pop-up-assign-practices/pop-up-assign-practices.component';

@Component({
  selector: 'app-assign-practice',
  templateUrl: './assign-practice.component.html',
  styleUrls: ['./assign-practice.component.scss']
})

export class AssignPracticeComponent {
  displayedColumns: string[] = [ 'Aplicante', 'Empresa'];
  dataSource = new MatTableDataSource<Solicitud>();
  selection = new SelectionModel<Solicitud>(true, []);
  @Output() messageEvent = new EventEmitter<Solicitud[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);
  constructor(private dialog : MatDialog, private SolicitudService: SolicitudService){ }
  ngOnInit(): void {
    this.dataSource.data = this.SolicitudService.getSolicitudes();
  }
  aceptar(): void {
    console.log("prácticas asignadas");
    this.dialog.open(PopUpAssignPracticesComponent);
  }
}
