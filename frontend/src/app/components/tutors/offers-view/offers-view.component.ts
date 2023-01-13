import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-offers-view',
  templateUrl: './offers-view.component.html',
  styleUrls: ['./offers-view.component.scss']
})
export class OffersViewComponent {
  displayedColumns: string[] = ['pos'];
  dataSource = new MatTableDataSource<Offer>();
  @Output() messageEvent = new EventEmitter<Offer[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private tutorService: TutorsService, private router: Router, private practiceService: PracticesService){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void{
    this.tutorService.getOffersByTutor().subscribe((data: Offer[]) => {
      this.dataSource.data = data;
      console.log(this.dataSource.data);
    });
  }

  guardar(): void {
    // for (let i = 0; i < this.dataSource.data.length; i++) {
    //   console.log(this.dataSource.data[i]);
    // }
    // this.tutorService.saveReports(this.dataSource.data);
    this.router.navigate(['/dashboard-tutors']);
  }
}
