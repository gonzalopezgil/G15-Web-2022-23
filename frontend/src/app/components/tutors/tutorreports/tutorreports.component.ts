import { Router, TitleStrategy } from '@angular/router';
import { TutorsService } from 'src/app/services/tutors.service';
import { ChangeDetectorRef, Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorIntl } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Report } from 'src/app/interfaces/report';
import { Practice } from 'src/app/interfaces/practice';
import { PracticesService } from 'src/app/services/practices.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-tutorreports',
  templateUrl: './tutorreports.component.html',
  styleUrls: ['./tutorreports.component.scss']
})
export class TutorreportsComponent {
  loadingState = true;
  reports: Report[] = [];
  displayedColumns: string[] = ['pos','name', 'schedule', 'weeks', 'report','mark'];
  dataSource = new MatTableDataSource<Report>();
  @Output() messageEvent = new EventEmitter<Report[]>();
  @ViewChild(MatPaginator) paginator: MatPaginator = new MatPaginator(new MatPaginatorIntl(), ChangeDetectorRef.prototype);;

  constructor(private tutorService: TutorsService, private router: Router, private practiceService: PracticesService, private userService: UsersService){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.loadingState = false;
  }

  ngOnInit(): void{
    this.downloadReports();
  }

  downloadReports(){
    this.dataSource.data = [];
    this.reports = [];
    this.tutorService.getPracticesByTutor().subscribe((practiceList: Practice[]) => {
      for (let i = 0; i < practiceList.length; i++) {
        this.practiceService.getOffer(practiceList[i].offer_id).subscribe((offer) => {
          this.userService.getStudentBy(practiceList[i].student_id).subscribe((student) => {
              let report = {
                id: practiceList[i].id,
                pos: i+1,
                name: student.first_name + ' ' + student.last_name,
                schedule: offer.schedule,
                weeks: offer.weeks,
                evaluation: practiceList[i].report,
                mark: practiceList[i].mark,
                start_date: practiceList[i].start_date,
                end_date: practiceList[i].end_date,
                offer_id: practiceList[i].offer_id,
                student_id: practiceList[i].student_id,
              }
              this.reports.push(structuredClone(report));
              this.dataSource.data.push(report);
              this.dataSource._updateChangeSubscription();
          });
        });
      }
    });
  }

  guardar(): void {
    for (let pos=0 ; pos < this.reports.length ; pos++) {
      let report = this.dataSource.data[pos];
      let practice = {
        id: report.id,
        offer_id: report.offer_id,
        student_id: report.student_id,
        report: report.evaluation,
        mark: report.mark,
        start_date: report.start_date,
        end_date: report.end_date,
      }
      this.practiceService.savePractice(practice).subscribe((response) => {
      }, (error) => {
        console.log(error);
      }, () => {
        this.router.navigate(['/dashboard-tutors']);
      });
    }
  }
}

