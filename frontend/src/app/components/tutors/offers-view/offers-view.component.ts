import { SelectionModel } from '@angular/cdk/collections';
import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Offer } from 'src/app/interfaces/offer';
import { PracticesService } from 'src/app/services/practices.service';
import { TutorsService } from 'src/app/services/tutors.service';
import { PopUpAddOfferComponent } from '../../pop-ups/pop-up-add-offer/pop-up-add-offer.component';

@Component({
  selector: 'app-offers-view',
  templateUrl: './offers-view.component.html',
  styleUrls: ['./offers-view.component.scss']
})
export class OffersViewComponent {
  displayedColumns: string[] = ['pos', 'category', 'position', 'vacancies', 'start_date'];
  dataSource = new MatTableDataSource<Offer>();
  selection = new SelectionModel<Offer>(true, []);
  @Output() messageEvent = new EventEmitter<Offer[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private tutorService: TutorsService, private router: Router, private practiceService: PracticesService, private dialog: MatDialog){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void{
    this.tutorService.getOffersByTutor().subscribe((data: Offer[]) => {
      this.dataSource.data = data;
      console.log(this.dataSource.data);
    });
  }

  newOffer(){
    this.dialog.open(PopUpAddOfferComponent, { data: false});
    this.router.navigate(['/tutors/offers']);
  }
}
