import { Component,OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { User } from 'src/app/interfaces/user';
import { UsersService } from 'src/app/services/users.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';

@Component({
  selector: 'app-userdata',
  templateUrl: './userdata.component.html',
  styleUrls: ['./userdata.component.scss']
})

export class UserdataComponent  implements OnInit{
  user: User | undefined;
  constructor(private usersService: UsersService,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.user = this.usersService.getUser();
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent); 
  }
}
