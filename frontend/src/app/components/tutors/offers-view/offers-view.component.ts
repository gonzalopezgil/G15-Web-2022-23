import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Report } from 'src/app/interfaces/report';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-offers-view',
  templateUrl: './offers-view.component.html',
  styleUrls: ['./offers-view.component.scss']
})
export class OffersViewComponent {
  displayedColumns: string[] = ['Posicion','position', 'category', 'vacancies', 'start_date'];
  dataSource = new MatTableDataSource<Report>();
  @Output() messageEvent = new EventEmitter<Report[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private tutorService: TutorsService,private router: Router){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void{
    this.dataSource.data = this.tutorService.getReports();
    for (let i = 0; i < this.dataSource.data.length; i++) {
      console.log(this.dataSource.data[i]);
    }
  }

  guardar(): void {
    for (let i = 0; i < this.dataSource.data.length; i++) {
      console.log(this.dataSource.data[i]);
    }
    this.tutorService.saveReports(this.dataSource.data);
    this.router.navigate(['/dashboard-tutors']);
  }
}
