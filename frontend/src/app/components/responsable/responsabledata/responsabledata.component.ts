import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Responsable } from 'src/app/interfaces/responsable';
import { UsersService } from 'src/app/services/users.service';
import { PopUpPasswordComponent } from '../../pop-ups/pop-up-password/pop-up-password.component';
@Component({
  selector: 'app-responsabledata',
  templateUrl: './responsabledata.component.html',
  styleUrls: ['./responsabledata.component.scss']
})
export class ResponsabledataComponent {
  responsable: Responsable | undefined;
  constructor(private usersService: UsersService,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.responsable = this.usersService.getRespnsable();
  }

  changePassword() {
    this.dialog.open(PopUpPasswordComponent); 
  }
}
