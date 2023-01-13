import { ThisReceiver } from '@angular/compiler';
import { Component,OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Student } from 'src/app/interfaces/student';
import { UsersService } from 'src/app/services/users.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-userdata',
  templateUrl: './userdata.component.html',
  styleUrls: ['./userdata.component.scss']
})

export class UserdataComponent  implements OnInit{
  user: Student | undefined;
  constructor(private usersService: UsersService,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.usersService.getStudent().subscribe((data: Student) => {
      this.user = data;
    });
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent, { data: true}); 
  }
  generatePDF() {
    this.usersService.getPDF().subscribe((data: any) => {
        const file = new Blob([data], { type: 'application/pdf' });
        const fileURL = URL.createObjectURL(file);
        window.open(fileURL);
      });
  }
}
