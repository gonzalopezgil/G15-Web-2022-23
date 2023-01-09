import { Component } from '@angular/core';
import { User } from 'src/app/interfaces/user';
import { MatTableDataSource } from '@angular/material/table';
import { UserListService } from 'src/app/services/user-list.service';
import { MatDialog } from '@angular/material/dialog';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-users-reports',
  templateUrl: './users-reports.component.html',
  styleUrls: ['./users-reports.component.scss']
})
export class UsersReportsComponent {
  displayedColumns: string[] = ['username','name','lastname','dni','mail','grade', 'dob','phone','hours'];
  dataSource = new MatTableDataSource<User>();
  constructor(private dialog : MatDialog, private UserListService: UserListService){ }
  ngOnInit(): void{
    this.dataSource.data = this.UserListService.getUsersList();
  }
}
