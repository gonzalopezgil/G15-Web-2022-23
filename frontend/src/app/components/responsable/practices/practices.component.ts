import { Component } from '@angular/core';
import { practiceReport } from 'src/app/interfaces/practiceReport';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { PracticeReportServiceService } from 'src/app/services/practice-report-service.service';
@Component({
  selector: 'app-practices',
  templateUrl: './practices.component.html',
  styleUrls: ['./practices.component.scss']
})
export class PracticesReportComponent {
  displayedColumns: string[] = ['name','lastname','grade','hours'];
  dataSource = new MatTableDataSource<practiceReport>();
  constructor(private dialog : MatDialog, private PracticeReportService: PracticeReportServiceService){ }
  ngOnInit(): void{
    this.dataSource.data = this.UserListService.getUsersList();
  }
}
